package com.example.instructorapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.instructorapi.dto.CreateInstructorRequest;
import com.example.instructorapi.model.Instructor;
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
    public List<Instructor> searchInstructorsBySpecialization(@RequestParam("specialization") String specialization) {
        return instructorService.searchInstructorsBySpecialization(specialization);
    }

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable String id) {
        return instructorService.getInstructorById(id);
    }

    @PostMapping
    public Instructor createInstructor(@Valid @RequestBody CreateInstructorRequest request) {
        // code to create an instructor
        Instructor instructor = new Instructor(request.getName(), request.getEmail(), request.getSpecialization(), request.getYearsExperience());
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable String id, @Valid @RequestBody Instructor instructor) {
        // code to update an instructor
        return instructorService.updateInstructor(instructor, id);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable String id) {
        // code to delete an instructor
        instructorService.deleteInstructor(id);
    }

    @GetMapping("/search")
    public List<Instructor> searchInstructorsByName(@RequestParam("keyword") String keyword) {
        return instructorService.searchInstructorsByKeyword(keyword);
    }
}   
