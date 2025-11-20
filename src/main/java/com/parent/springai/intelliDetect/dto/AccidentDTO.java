package com.parent.springai.intellidetect.dto;

public class AccidentDTO {
    private String videoUrl;
    private String imageUrl;
    private String accidentDescription;
    private String accidentDescriptionText;
    private String accidentDescriptionTime;
    private String accidentDescriptionState;
    
    // 构造方法
    public AccidentDTO() {}
    
    // Getter和Setter方法
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
}