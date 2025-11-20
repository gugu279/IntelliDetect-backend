package com.parent.springai.intellidetect.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accident_info")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "video_url", nullable = false, length = 500)
    private String videoUrl;
    
    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;
    
    @Column(name = "accident_description", nullable = false, columnDefinition = "TEXT")
    private String accidentDescription;
    
    @Column(name = "accident_description_text", nullable = false, columnDefinition = "TEXT")
    private String accidentDescriptionText;
    
    @Column(name = "accident_description_time", nullable = false, columnDefinition = "TEXT")
    private String accidentDescriptionTime;
    
    @Column(name = "accident_description_state", nullable = false, columnDefinition = "TEXT")
    private String accidentDescriptionState;
    
    @Column(name = "display_info", columnDefinition = "TEXT")
    private String displayInfo;
    
    @Column(name = "created_time")
    private LocalDateTime createdTime = LocalDateTime.now();
    
    // 构造方法
    public Accident() {}
    
    public Accident(String videoUrl, String imageUrl, String accidentDescription, 
                   String accidentDescriptionText, String accidentDescriptionTime, 
                   String accidentDescriptionState) {
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.accidentDescription = accidentDescription;
        this.accidentDescriptionText = accidentDescriptionText;
        this.accidentDescriptionTime = accidentDescriptionTime;
        this.accidentDescriptionState = accidentDescriptionState;
    }
    
    // Getter和Setter方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public String getAccidentDescription() { return accidentDescription; }
    public void setAccidentDescription(String accidentDescription) { this.accidentDescription = accidentDescription; }
    
    public String getAccidentDescriptionText() { return accidentDescriptionText; }
    public void setAccidentDescriptionText(String accidentDescriptionText) { this.accidentDescriptionText = accidentDescriptionText; }
    
    public String getAccidentDescriptionTime() { return accidentDescriptionTime; }
    public void setAccidentDescriptionTime(String accidentDescriptionTime) { this.accidentDescriptionTime = accidentDescriptionTime; }
    
    public String getAccidentDescriptionState() { return accidentDescriptionState; }
    public void setAccidentDescriptionState(String accidentDescriptionState) { this.accidentDescriptionState = accidentDescriptionState; }
    
    public String getDisplayInfo() { return displayInfo; }
    public void setDisplayInfo(String displayInfo) { this.displayInfo = displayInfo; }
    
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
}