package com.parent.springai.intellidetect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObstacleDTO {
    @JsonProperty("imageUrl")
    private String imageUrl;
    
    @JsonProperty("location")
    private String location;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("height")
    private Double height;
    
    @JsonProperty("distance")
    private Double distance;
    
    @JsonProperty("riskLevel")
    private String riskLevel;
    
    @JsonProperty("coordinates")
    private CoordinatesDTO coordinates;
    
    // 构造方法
    public ObstacleDTO() {}
    
    // Getter和Setter方法
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
    
    public CoordinatesDTO getCoordinates() { return coordinates; }
    public void setCoordinates(CoordinatesDTO coordinates) { this.coordinates = coordinates; }
    
    // 内部坐标类
    public static class CoordinatesDTO {
        @JsonProperty("latitude")
        private Double latitude;
        
        @JsonProperty("longitude")
        private Double longitude;
        
        public CoordinatesDTO() {}
        
        public Double getLatitude() { return latitude; }
        public void setLatitude(Double latitude) { this.latitude = latitude; }
        
        public Double getLongitude() { return longitude; }
        public void setLongitude(Double longitude) { this.longitude = longitude; }
    }
}