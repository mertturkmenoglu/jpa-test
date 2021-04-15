package com.mertturkmenoglu.jpatest.controllers;

import java.util.List;

import com.mertturkmenoglu.jpatest.dto.AddStudentDto;
import com.mertturkmenoglu.jpatest.models.Student;
import com.mertturkmenoglu.jpatest.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

  @Autowired
  private StudentService service;

  @GetMapping("/")
  public List<Student> getAllStudents() {
    return this.service.getStudents();
  }

  @GetMapping("/{id}")
  public Student getStudentById(@PathVariable("id") int id) {
    return this.service.getStudent(id);
  }

  @PostMapping("/")
  public Student addStudent(@RequestBody AddStudentDto dto) {
    var student = new Student();
    student.setName(dto.getName());
      return this.service.addStudent(student);
  }

  @DeleteMapping("/{id}")
  public void removeStudent(@PathVariable("id") int id) {
    this.service.removeStudent(id);
  }
}
