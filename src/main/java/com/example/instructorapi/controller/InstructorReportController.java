package com.example.instructorapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.instructorapi.dto.InstructorSpecializationSummary;
import com.example.instructorapi.dto.InstructorStatusSummary;
import com.example.instructorapi.service.InstructorReportService;

@RestController
@RequestMapping("api/v1/reports/instructors")
public class InstructorReportController {
    private final InstructorReportService instructorReportService;

    public InstructorReportController(InstructorReportService instructorReportService) {
        this.instructorReportService = instructorReportService;
    }

    @GetMapping("/by-status")
    public List<InstructorStatusSummary> getInstructorStatusSummary() {
        return instructorReportService.getInstructorStatusSummary();
    }

    @GetMapping("/by-specialization")
    public List<InstructorSpecializationSummary> getInstructorSpecializationSummary() {
        return instructorReportService.getInstructorSpecializationSummary();
    }
}
