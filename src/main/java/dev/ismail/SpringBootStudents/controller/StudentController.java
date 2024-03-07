package dev.ismail.SpringBootStudents.controller;

import dev.ismail.SpringBootStudents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import dev.ismail.SpringBootStudents.model.Student;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {


    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> findALLStudent() {
        return studentRepository.findAll();
    }



}
