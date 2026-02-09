package com.BrainyByte.road_ai_system.controller;

import com.BrainyByte.road_ai_system.model.AiResult;
import com.BrainyByte.road_ai_system.model.AnalysisResponse;
import com.BrainyByte.road_ai_system.model.RoadIssue;
import com.BrainyByte.road_ai_system.repository.RoadIssueRepository;
import com.BrainyByte.road_ai_system.service.AiService;
import com.BrainyByte.road_ai_system.service.SeverityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class AnalyzeController {

    private final AiService aiService;
    private final SeverityService severityService;
    private final RoadIssueRepository repository;

    public AnalyzeController(AiService aiService,
                             SeverityService severityService,
                             RoadIssueRepository repository) {
        this.aiService = aiService;
        this.severityService = severityService;
        this.repository = repository;
    }

    @PostMapping("/analyze")
    public RoadIssue analyze(@RequestParam String imageName) {

        AiResult aiResult = aiService.analyzeImage(imageName);
        String severity = severityService.calculateSeverity(aiResult);

        RoadIssue issue = new RoadIssue();
        issue.setImageUrl(imageName);
        issue.setPotholeSize(aiResult.getPotholeSize());
        issue.setConfidence(aiResult.getConfidence());
        issue.setSeverity(severity);
        issue.setCreatedAt(LocalDateTime.now());

        return repository.save(issue);
    }


}