package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/student")
// Controller
public class StudentController {
    // Create a list to store students
    private List<Student> studentList = new ArrayList<>();
    /*
    @PostMapping("")
    public ResponseEntity<?> insertStudentbyBody(@RequestBody Student student) {
        studentList.add(student);
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
     */
    @PostMapping("")
    // use form
    public ResponseEntity<?> AddStudentByForm(Student student) {
        // Add the new student to the list
        studentList.add(student);
        return new ResponseEntity<>("Student added successfully", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<?> GetStudent() {
        // Return the list of students
        // Spring Boot ResponseEntity hỗ trợ thư viện Jackson convert JAVA object thành JSON (giống
        // thư viện gson trong Servlet)
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    @PostMapping("/{name}/{age}")
    public ResponseEntity<?> insertStudentbyPath(@PathVariable String name, @PathVariable int age) {
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        studentList.add(student);
        return new ResponseEntity<>("Student added successfully", HttpStatus.OK);
    }
}
// Code first vs database first