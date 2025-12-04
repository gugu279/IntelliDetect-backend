package com.parent.springai.intellidetect.service;

import com.parent.springai.intellidetect.entity.Obstacle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ObstacleService {
    Long createObstacle(String imageUrl, String location, String type,
                       Double height, Double distance, String riskLevel,
                       Double latitude, Double longitude);
    
    void updateObstacleStatus(Long id, String status);
    
    Page<Obstacle> getObstacles(Pageable pageable);
    
    Obstacle getObstacleById(Long id);
    
    Map<String, Long> getObstacleStats();
    
    List<Obstacle> getHighRiskObstacles();
}