package com.example.instructorapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.instructorapi.model.InstructorModel;

@Service
public class InstructorService {
    private final List<InstructorModel> instructors = new ArrayList<>();    

    public List<InstructorModel> getInstructors() {
        instructors.add(new InstructorModel("John Doe", "johndoe@example.com", "Java", 5));
        instructors.add(new InstructorModel("Jane Doe", "janedoe@example.com", "Spring Boot", 7));
        return instructors;
    }

    public InstructorModel createInstructor(InstructorModel instructor) {
        instructors.add(instructor);
        return instructor;
    }
}
