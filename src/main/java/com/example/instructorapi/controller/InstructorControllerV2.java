package com.example.instructorapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.instructorapi.dto.InstructorResponseV2;
import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.service.InstructorService;

@RestController
@RequestMapping("/api/v2/instructors")
public class InstructorControllerV2 {
    private final InstructorService instructorService;

    public InstructorControllerV2(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    
    @GetMapping
    public List<InstructorResponseV2> getInstructors() {
        return instructorService.getInstructors()
        .stream()
        .map(this::mapToResponseV2)
        .toList();
    }

    @GetMapping("/{id}")
    public InstructorResponseV2 getInstructorById(@PathVariable String id) {
         Instructor instructor = instructorService.getInstructorById(id);
        return mapToResponseV2(instructor);
    }

    private InstructorResponseV2 mapToResponseV2(Instructor instructor) {
        String availabilityStatus = instructor.getStatus().equals("ACTIVE") ? "Available for Teaching" : "Not Available for Teaching";
        String experienceLevel = instructor.getYearsExperience() < 3 ? "Junior" : instructor.getYearsExperience() < 6 ? "Intermediate" : "Senior";
        String profileSummary = instructor.getName()
        + " specializes in " + instructor.getSpecialization() 
        + " and has " + instructor.getYearsExperience() 
        + " years of teaching experience.";
    
        return new InstructorResponseV2(instructor.getId(), instructor.getName(), instructor.getSpecialization(), availabilityStatus, experienceLevel, profileSummary);
    }
}   
