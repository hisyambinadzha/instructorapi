package com.example.instructorapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.instructorapi.model.Instructor;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
    
    public List<Instructor> findAll();

    public Instructor getInstructorById(String id);

    public Instructor createInstructor(Instructor instructor);

    public Instructor updateInstructor(Instructor instructor, String id);

    public void deleteInstructor(String id);
}
