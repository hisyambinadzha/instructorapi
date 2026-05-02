package com.example.instructorapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.repository.InstructorRepository;

@Service
public class InstructorService {
    private final Logger logger = LoggerFactory.getLogger(InstructorService.class);
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getInstructors() {
        logger.info("Getting all instructors");

        List<Instructor> instructors = instructorRepository.findAll();

        logger.info("Found " + instructors.size() + " instructors");

        return instructors;
    }

    public Instructor getInstructorById(String id) {
        logger.info("Getting instructor with id '{}'", id);

        return instructorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor with id '" + id + "' does not exist"));
    }

    public Instructor createInstructor(Instructor instructor) {
        logger.info("Creating instructor");

        Instructor savedInstructor = instructorRepository.save(instructor);

        logger.info("Created instructor with id '{}'", savedInstructor.getId());

        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Instructor instructor, String id) {
        logger.info("Updating instructor with id '{}'", id);

        if (!instructorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor with id '" + id + "' does not exist");
        }

        Instructor updatedInstructor = getInstructorById(id);
        updatedInstructor.setName(instructor.getName());
        updatedInstructor.setEmail(instructor.getEmail());
        updatedInstructor.setSpecialization(instructor.getSpecialization());
        updatedInstructor.setYearsExperience(instructor.getYearsExperience());
        instructorRepository.save(updatedInstructor);

        logger.info("Updated instructor with id '{}'", id);

        return updatedInstructor;
    }

    public void deleteInstructor(String id) {
        logger.info("Deleting instructor with id '{}'", id);

        if (!instructorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor with id '" + id + "' does not exist");
        }

        instructorRepository.deleteById(id);
    }

    public List<Instructor> searchInstructorsByKeyword(String keyword) {
        logger.info("Searching instructors by keyword '{}'", keyword);

        List<Instructor> instructors = instructorRepository.findByNameContainingIgnoreCase(keyword);

        logger.info("Found {} instructors", instructors.size());

        return instructors;
    }

    public List<Instructor> searchInstructorsBySpecialization(String specialization) {
        logger.info("Searching instructors by specialization '{}'", specialization);

        List<Instructor> instructors = instructorRepository.findBySpecialization(specialization);

        logger.info("Found {} instructors", instructors.size());

        return instructors;
    }

    public Page<Instructor> getAllInstructors(Pageable pageable) {
        logger.info("Fetching paged instructors: page {}, size {}", pageable.getPageNumber(), pageable.getPageSize());

        Page<Instructor> instructors = instructorRepository.findAll(pageable);
        
        logger.info("Found {} instructors", instructors.getTotalElements());

        return instructors;
    }

    public Page<Instructor> getInstructorsBySpecialization(String specialization, Pageable pageable) {
        logger.info("Fetching paged instructors by specialization: page {}, size {}", pageable.getPageNumber(),
                pageable.getPageSize());

        Page<Instructor> instructors = instructorRepository.findBySpecialization(specialization, pageable);

        logger.info("Found {} instructors", instructors.getTotalElements());

        return instructors;
    }

    public Page<Instructor> getInstructorsBySpecializationAndNameContainingIgnoreCase(String specialization,
            String name, Pageable pageable) {
        logger.info("Fetching paged instructors by specialization and name: page {}, size {}", pageable.getPageNumber(),
                pageable.getPageSize());
        
                Page<Instructor> instructors = instructorRepository
                .findBySpecializationAndNameContainingIgnoreCase(specialization, name, pageable);

        logger.info("Found {} instructors", instructors.getTotalElements());

        return instructors;
    }
}
