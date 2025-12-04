package com.parent.springai.intellidetect.controller;

import com.parent.springai.intellidetect.dto.ObstacleDTO;
import com.parent.springai.intellidetect.dto.StatusUpdateDTO;
import com.parent.springai.intellidetect.entity.Obstacle;
import com.parent.springai.intellidetect.service.ObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/obstacles")
@CrossOrigin(origins = "*")
public class ObstacleController {
    
    @Autowired
    private ObstacleService obstacleService;
    
    @PostMapping
    public ResponseEntity<Map<String, Object>> createObstacle(@RequestBody ObstacleDTO obstacleDTO) {
        try {
            // 从 CoordinatesDTO 中提取经纬度
            Double latitude = obstacleDTO.getCoordinates() != null ? 
                obstacleDTO.getCoordinates().getLatitude() : null;
            Double longitude = obstacleDTO.getCoordinates() != null ? 
                obstacleDTO.getCoordinates().getLongitude() : null;
            
            Long obstacleId = obstacleService.createObstacle(
                obstacleDTO.getImageUrl(),
                obstacleDTO.getLocation(),
                obstacleDTO.getType(),
                obstacleDTO.getHeight(),
                obstacleDTO.getDistance(),
                obstacleDTO.getRiskLevel(),
                latitude,
                longitude
            );
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "创建成功");
            
            Map<String, Object> data = new HashMap<>();
            data.put("id", obstacleId);
            response.put("data", data);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> updateObstacleStatus(@PathVariable Long id, 
                                                                  @RequestBody StatusUpdateDTO statusUpdateDTO) {
        try {
            obstacleService.updateObstacleStatus(id, statusUpdateDTO.getStatus());
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "状态更新成功");
            
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            response.put("data", data);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping
    public ResponseEntity<Map<String, Object>> getObstacles(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page - 1, size);
            Page<Obstacle> obstaclePage = obstacleService.getObstacles(pageable);
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "查询成功");
            
            Map<String, Object> data = new HashMap<>();
            data.put("total", obstaclePage.getTotalElements());
            data.put("records", obstaclePage.getContent());
            data.put("page", page);
            data.put("size", size);
            data.put("totalPages", obstaclePage.getTotalPages());
            response.put("data", data);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getObstacleById(@PathVariable Long id) {
        try {
            Obstacle obstacle = obstacleService.getObstacleById(id);
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", obstacle);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getObstacleStats() {
        try {
            Map<String, Long> stats = obstacleService.getObstacleStats();
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", stats);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/high-risk")
    public ResponseEntity<Map<String, Object>> getHighRiskObstacles() {
        try {
            List<Obstacle> highRiskObstacles = obstacleService.getHighRiskObstacles();
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", highRiskObstacles);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}