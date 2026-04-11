package com.example.instructorapi.controiller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    /**
     * Returns a map with the status and message of the application.
     * The status is "Ok" and the message is "Healthy".
     * @return a map with the status and message of the application
     */
    @GetMapping("/api/health")
    public String health() {
        return Map.of(
                "status", "Ok",
                "message", "Healthy").toString();
    }
}
