package com.example.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.example.models.Student;

@Controller
public class StudentsController {
   @GetMapping(value = "/students/view")
   public String getAllStudents(Model model) {
        System.out.println("Getting all students");

        List<Student> students = new ArrayList<>();
        students.add(new Student("bobby", 125, 79,"black","4"));
        students.add(new Student("sara", 135, 68,"brown","4"));
        students.add(new Student("steve", 140, 77 ,"blond","2"));
        students.add(new Student("victor", 215, 89,"black","4.3"));
        
        model.addAttribute("stu", students);
        return "students/showAll";
   }
    
}
