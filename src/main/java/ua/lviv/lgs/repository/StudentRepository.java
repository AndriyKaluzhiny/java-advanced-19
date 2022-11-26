package ua.lviv.lgs.repository;

import org.springframework.beans.PropertyValues;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
