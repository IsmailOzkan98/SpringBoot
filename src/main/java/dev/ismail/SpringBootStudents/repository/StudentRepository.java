package dev.ismail.SpringBootStudents.repository;

import dev.ismail.SpringBootStudents.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



}
