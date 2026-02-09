package com.BrainyByte.road_ai_system.service;

import com.BrainyByte.road_ai_system.model.AiResult;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class AiService {

    private static final String AI_URL = "http://localhost:8000/predict";
    private final RestTemplate restTemplate = new RestTemplate();

    public AiResult analyzeImage(String imageName) {

        String aiUrl = "http://localhost:8000/predict";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("imageName", imageName);

        HttpEntity<Map<String, String>> request =
                new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AiResult> response =
                restTemplate.postForEntity(aiUrl, request, AiResult.class);

        return response.getBody();
    }

}
