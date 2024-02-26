package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

import com.example.models.Student;
import com.example.models.StudentsRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentsController {
   
   @Autowired
   private StudentsRepository studentRepo;

   @GetMapping(value = "/students/view")
   public String getAllStudents(Model model) {
        System.out.println("Getting all students");

        List<Student> students = studentRepo.findAll();
        
        model.addAttribute("stu", students);
        return "students/showAll";
   }
   
   @PostMapping("/students/add")
   public String addStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
      System.out.println("ADD student");
      String newName = newstudent.get("name");
      int newHeight = Integer.parseInt(newstudent.get("height"));
      int newWeight = Integer.parseInt(newstudent.get("weight"));
      String newHairColor = newstudent.get("hairColor");
      String newGPA = newstudent.get("gpa");
      studentRepo.save(new Student(newName,newHeight,newWeight,newHairColor,newGPA));
      response.setStatus(201);
      return "students/addedStudent";
   }
   
}
