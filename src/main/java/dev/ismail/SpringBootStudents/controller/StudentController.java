package dev.ismail.SpringBootStudents.controller;

import dev.ismail.SpringBootStudents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.ismail.SpringBootStudents.model.Student;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> findALLStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    @PostMapping("save_student")
    public  String saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "successfully saved";
    }
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email) {

        return studentRepository.findByEmail(email);
    }
    @PutMapping("/update-student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student student) {
        Student updateStudent = studentRepository.findById(id).orElseThrow();
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setEmail(student.getEmail());

        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("delete_student/{id}")
    public String deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
        return "successfully DELETED";
    }

    @GetMapping("/random-number")
    public Map<String, Object> getRandomNumber() {
        Map<String, Object> randnumber = new HashMap<String, Object>();
        Random random = new Random();
        int randomNumber = random.nextInt(9999);
        randnumber.put("description", "A random number");
        randnumber.put("numb", randomNumber);
        JSONObject result = new JSONObject(randnumber);
        return randnumber;
    }
}
