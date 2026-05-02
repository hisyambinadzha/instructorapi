package com.example.instructorapi.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import com.example.instructorapi.dto.InstructorSpecializationSummary;
import com.example.instructorapi.dto.InstructorStatusSummary;

@Service
public class InstructorReportService {
    private final MongoTemplate mongoTemplate;

    public InstructorReportService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<InstructorStatusSummary> getInstructorStatusSummary() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("status").count().as("totalInstructors"),
                Aggregation.project("totalInstructors").and("_id").as("status"),
                Aggregation.sort(Sort.Direction.ASC, "status"));
        return mongoTemplate
                .aggregate(aggregation, "instructors", InstructorStatusSummary.class)
                .getMappedResults();
    }

    public List<InstructorSpecializationSummary> getInstructorSpecializationSummary() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("specialization").count().as("totalInstructors"),
                Aggregation.project("totalInstructors").and("_id").as("specialization"),
                Aggregation.sort(Sort.Direction.ASC, "specialization"));
        return mongoTemplate
                .aggregate(aggregation, "instructors", InstructorSpecializationSummary.class)
                .getMappedResults();
    }
}
