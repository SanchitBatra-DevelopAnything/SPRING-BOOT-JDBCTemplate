package com.example.finalTryJDBC.demo.Controller;


import com.example.finalTryJDBC.demo.Domain.Student;
import com.example.finalTryJDBC.demo.Service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<Object> getStudents()
    {
        ArrayList<Student> studentList = studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }

    @PostMapping("/students")
    public ResponseEntity<Object> addStudent(@RequestBody Student student)
    {
        try
        {
            Student added = this.studentService.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(added);
        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int id)
    {
        try{
            this.studentService.deleteStudent(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully!");
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
