package com.example.instructorapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.instructorapi.model.InstructorModel;
import com.example.instructorapi.service.InstructorService;

@RestController
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    
    @GetMapping("/api/instructors")
    public Map<String,Object> instructors() {
        // code to get all instructors
        List<InstructorModel> instructors = instructorService.getInstructors();

        Map<String, Object> response = Map.of(
            "instructors", instructors
        );

        return response;
    }
}   
