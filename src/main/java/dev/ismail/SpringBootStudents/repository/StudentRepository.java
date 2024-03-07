package dev.ismail.SpringBootStudents.repository;

import dev.ismail.SpringBootStudents.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByEmail(String email);

}
