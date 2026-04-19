package com.example.instructorapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.repository.InstructorRepository;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository; 

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    public List<Instructor> getInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(String id) {
        return instructorRepository.getInstructorById(id);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Instructor instructor, String id) {
        return instructorRepository.updateById(instructor, id);
    }

    public void deleteInstructor(String id) {
        instructorRepository.deleteById(id);
    }

    public List<Instructor> searchInstructorsByKeyword(String keyword) {
        return instructorRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Instructor> searchInstructorsBySpecialization(String specialization) {
        return instructorRepository.findBySpecialization(specialization);
    }

    public Page<Instructor> getAllInstructors(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    public Page<Instructor> getInstructorsBySpecialization(String specialization, Pageable pageable) {
        return instructorRepository.findBySpecialization(specialization, pageable);
    }
}
