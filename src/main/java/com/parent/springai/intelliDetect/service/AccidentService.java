package com.parent.springai.intellidetect.service;

import com.parent.springai.intellidetect.entity.Accident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface AccidentService {
    Long createAccident(String videoUrl, String imageUrl, String accidentDescription,
                       String accidentDescriptionText, String accidentDescriptionTime,
                       String accidentDescriptionState);
    
    void updateDisplayInfo(Long id, String displayInfo);
    
    Page<Accident> getAccidents(Pageable pageable);
    
    Accident getAccidentById(Long id);
    
    Map<String, Long> getAccidentStats();
}