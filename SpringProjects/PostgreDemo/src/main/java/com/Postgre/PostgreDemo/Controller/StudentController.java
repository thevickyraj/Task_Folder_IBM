package com.Postgre.PostgreDemo.Controller;

import com.Postgre.PostgreDemo.Student;
import com.Postgre.PostgreDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @PostMapping("/students")
    public Student save(@RequestBody Student student){
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAll(){
        return repository.findAll();
    }
}
