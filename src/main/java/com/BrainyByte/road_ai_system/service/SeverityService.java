package com.BrainyByte.road_ai_system.service;

import com.BrainyByte.road_ai_system.model.AiResult;
import org.springframework.stereotype.Service;

@Service
public class SeverityService {

    public String calculateSeverity(AiResult aiResult) {

        if (!aiResult.isPotholeDetected()) {
            return "NONE";
        }

        if (aiResult.getPotholeSize() > 300) {
            return "HIGH";
        }

        if (aiResult.getPotholeSize() > 150) {
            return "MEDIUM";
        }

        return "LOW";
    }

    public String generateUserMessage(String severity) {

        return switch (severity) {
            case "HIGH" -> "Severe pothole detected. This can be dangerous. Immediate repair required.";
            case "MEDIUM" -> "Moderate road damage detected. Repair recommended soon.";
            case "LOW" -> "Minor road damage detected. Monitor the situation.";
            default -> "No road damage detected.";
        };
    }

}