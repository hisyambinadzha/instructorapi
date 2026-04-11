package com.example.instructorapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.instructorapi.dto.CreateInstructorRequest;
import com.example.instructorapi.model.InstructorModel;
import com.example.instructorapi.service.InstructorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    
    @GetMapping
    public Map<String,Object> instructors() {
        // code to get all instructors
        List<InstructorModel> instructors = instructorService.getInstructors();

        Map<String, Object> response = Map.of(
            "instructors", instructors
        );
        return response;
    }

    @PostMapping
    public InstructorModel createInstructor(@Valid @RequestBody CreateInstructorRequest request) {
        // code to create an instructor
        InstructorModel instructor = new InstructorModel(request.getName(), request.getEmail(), request.getSpecialization(), request.getYearsExperience());
        return instructorService.createInstructor(instructor);
    }

}   
