package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.dto.StudentDto;
import ua.lviv.lgs.service.StudentService;
import ua.lviv.lgs.service.impl.StudentServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class StudentController {

    @Autowired
    private StudentService service = new StudentServiceImpl();

    @PostMapping("/create")
    public StudentDto createStudent(@RequestParam(name = "firstName") String firstName, @RequestParam String lastName, @RequestParam Integer age, @RequestParam("file") MultipartFile file) throws IOException {
        Student studentToCreate = new Student();
        studentToCreate.setFirstName(firstName);
        studentToCreate.setLastName(lastName);
        studentToCreate.setAge(age);
        studentToCreate.setFileName(file.getName());
        studentToCreate.setFileType(file.getContentType());
        studentToCreate.setData(file.getBytes());
        service.create(studentToCreate);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(studentToCreate.getId()).toUriString();

        StudentDto dto = new StudentDto(firstName,lastName,age,uri);

        return dto;
    }

    @GetMapping("/downloadFile/{studentId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String studentId) throws FileNotFoundException {

        Student student = service.readById(studentId);


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(student.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + student.getFileName() + "\"")
                .body(new ByteArrayResource(student.getData()));
    }





}
