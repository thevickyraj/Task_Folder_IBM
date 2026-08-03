package com.Postgre.PostgreDemo.repository;

import com.Postgre.PostgreDemo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}