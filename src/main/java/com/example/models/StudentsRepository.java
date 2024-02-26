package com.example.models;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentsRepository extends JpaRepository<Student,Integer> {
    List<Student> findByHeight(int height); 
    Student findByName(String name); 
}
