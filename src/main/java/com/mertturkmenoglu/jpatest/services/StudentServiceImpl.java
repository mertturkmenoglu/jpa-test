package com.mertturkmenoglu.jpatest.services;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.mertturkmenoglu.jpatest.models.Student;
import com.mertturkmenoglu.jpatest.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository repository;

  public List<Student> getStudents() {
    return StreamSupport.stream(
      Spliterators.spliteratorUnknownSize(this.repository.findAll().iterator(), Spliterator.ORDERED), false
    ).collect(Collectors.toList());
  }

  public Student getStudent(int id) {
    var student = this.repository.findById(id);
    if (student.isPresent()) {
      return student.get();
    }

    return null;
  }

  public Student addStudent(Student dto) {
    return this.repository.save(dto);
  }

  public void removeStudent(int id) {
    this.repository.deleteById(id);
  }
}
