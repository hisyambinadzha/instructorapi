package com.example.instructorapi.controiller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
/*************  ✨ Windsurf Command ⭐  *************/
    /**
     * Returns a map with the status and message of the application.
     * The status is "Ok" and the message is "Healthy".
     * @return a map with the status and message of the application
     */
/*******  3f0d03c5-d4fb-4648-bf22-956b4c3f721b  *******/
    @GetMapping("/api/health")
    public String health() {
        return Map.of(
                "status", "Ok",
                "message", "Healthy").toString();
    }
}
