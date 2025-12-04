package com.parent.springai.intellidetect.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "obstacle_info")
public class Obstacle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;
    
    @Column(name = "location", nullable = false, length = 200)
    private String location;
    
    @Column(name = "type", nullable = false, length = 50)
    private String type; // building, crane, tree, equipment, other
    
    @Column(name = "height", nullable = false)
    private Double height;
    
    @Column(name = "distance", nullable = false)
    private Double distance;
    
    @Column(name = "risk_level", nullable = false, length = 20)
    private String riskLevel; // low, medium, high
    
    @Column(name = "status", nullable = false, length = 20)
    private String status = "pending"; // pending, confirmed, resolved
    
    @Column(name = "detection_time", nullable = false)
    private LocalDateTime detectionTime = LocalDateTime.now();
    
    @Column(name = "latitude")
    private Double latitude;
    
    @Column(name = "longitude")
    private Double longitude;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "created_time")
    private LocalDateTime createdTime = LocalDateTime.now();
    
    @Column(name = "updated_time")
    private LocalDateTime updatedTime = LocalDateTime.now();
    
    // 构造方法
    public Obstacle() {}
    
    public Obstacle(String imageUrl, String location, String type, Double height, 
                   Double distance, String riskLevel, Double latitude, Double longitude) {
        this.imageUrl = imageUrl;
        this.location = location;
        this.type = type;
        this.height = height;
        this.distance = distance;
        this.riskLevel = riskLevel;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    // Getter和Setter方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }
    
    public Double getDistance() { return distance; }
    public void setDistance(Double distance) { this.distance = distance; }
    
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getDetectionTime() { return detectionTime; }
    public void setDetectionTime(LocalDateTime detectionTime) { this.detectionTime = detectionTime; }
    
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
    
    public LocalDateTime getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(LocalDateTime updatedTime) { this.updatedTime = updatedTime; }
}