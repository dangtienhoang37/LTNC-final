package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Student")
public class StudentController {
    @Autowired
    private StudentRepository repository;

    // dang req: http://localhost:8081/api/v1/Student
    @GetMapping("")
    List<Student> getAllStudents() {
        return repository.findAll();
    }
}
