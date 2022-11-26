package ua.lviv.lgs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.repository.StudentRepository;
import ua.lviv.lgs.service.StudentService;

import java.util.stream.Stream;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student readById(String id) {
        return Stream.generate(studentRepository.findAll().iterator()::next).filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }
}
