package com.mertturkmenoglu.jpatest.repositories;

import com.mertturkmenoglu.jpatest.models.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
  
}
