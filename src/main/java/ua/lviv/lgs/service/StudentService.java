package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.domain.Student;

import java.util.List;

@Service
public interface StudentService {
    Student create(Student student);
    Student readById(String id);

}
