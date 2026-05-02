package com.example.instructorapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.instructorapi.model.Instructor;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {

    List<Instructor> findByNameContainingIgnoreCase(String name);

    List<Instructor> findBySpecialization(String specialization);

    Page<Instructor> findAll(Pageable pageable);

    Page<Instructor> findBySpecialization(String specialization, Pageable pageable);

    Page<Instructor> findBySpecializationAndNameContainingIgnoreCase(String specialization, String name, Pageable pageable);
}
