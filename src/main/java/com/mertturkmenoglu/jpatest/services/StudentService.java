package com.mertturkmenoglu.jpatest.services;

import java.util.List;

import com.mertturkmenoglu.jpatest.models.Student;

public interface StudentService {
  List<Student> getStudents();
  Student getStudent(int id);
  Student addStudent(Student dto);
  void removeStudent(int id);
}
