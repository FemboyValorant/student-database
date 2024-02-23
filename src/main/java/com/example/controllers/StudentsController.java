package com.example.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.example.models.Students;

@Controller
public class StudentsController {
   @GetMapping(value = "/students/view")
   public String getAllStudents(Model model) {
        System.out.println("Getting all students");

        List<Students> students = new ArrayList<>();
        students.add(new Students("bobby", "125", "6'3","black","4"));
        students.add(new Students("sara", "135", "5'5","brown","4"));
        students.add(new Students("steve", "140", "6'3","blond","2"));
        students.add(new Students("victor", "215", "7'5","black","4.3"));
        
        model.addAttribute("stu", students);
        return "students/showAll";
   }
    
}
