package com.example.instructorapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.instructorapi.model.InstructorModel;

public interface InstructorRepository extends MongoRepository<InstructorModel, String> {
    
}
