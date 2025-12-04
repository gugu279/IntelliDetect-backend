package com.parent.springai.intellidetect.service.impl;

import com.parent.springai.intellidetect.entity.Obstacle;
import com.parent.springai.intellidetect.repository.ObstacleRepository;
import com.parent.springai.intellidetect.service.ObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ObstacleServiceImpl implements ObstacleService {
    
    @Autowired
    private ObstacleRepository obstacleRepository;
    
    @Override
    public Long createObstacle(String imageUrl, String location, String type,
                             Double height, Double distance, String riskLevel,
                             Double latitude, Double longitude) {
        Obstacle obstacle = new Obstacle(imageUrl, location, type, height, distance, 
                                       riskLevel, latitude, longitude);
        
        Obstacle savedObstacle = obstacleRepository.save(obstacle);
        return savedObstacle.getId();
    }
    
    @Override
    public void updateObstacleStatus(Long id, String status) {
        Obstacle obstacle = obstacleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("障碍物信息不存在"));
        
        obstacle.setStatus(status);
        obstacle.setUpdatedTime(java.time.LocalDateTime.now());
        obstacleRepository.save(obstacle);
    }
    
    @Override
    public Page<Obstacle> getObstacles(Pageable pageable) {
        return obstacleRepository.findAll(pageable);
    }
    
    @Override
    public Obstacle getObstacleById(Long id) {
        return obstacleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("障碍物信息不存在"));
    }
    
    @Override
    public Map<String, Long> getObstacleStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalObstacles", obstacleRepository.countTotalObstacles());
        stats.put("highRiskObstacles", obstacleRepository.countHighRiskObstacles());
        stats.put("pendingObstacles", obstacleRepository.countPendingObstacles());
        stats.put("resolvedObstacles", obstacleRepository.countResolvedObstacles());
        stats.put("todayObstacles", obstacleRepository.countTodayObstacles());
        return stats;
    }
    
    @Override
    public List<Obstacle> getHighRiskObstacles() {
        return obstacleRepository.findHighRiskObstacles();
    }
}