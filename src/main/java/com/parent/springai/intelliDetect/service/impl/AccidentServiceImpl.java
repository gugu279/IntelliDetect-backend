package com.parent.springai.intellidetect.service.impl;

import com.parent.springai.intellidetect.entity.Accident;
import com.parent.springai.intellidetect.repository.AccidentRepository;
import com.parent.springai.intellidetect.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccidentServiceImpl implements AccidentService {
    
    @Autowired
    private AccidentRepository accidentRepository;
    
    @Override
    public Long createAccident(String videoUrl, String imageUrl, String accidentDescription,
                             String accidentDescriptionText, String accidentDescriptionTime,
                             String accidentDescriptionState) {
        Accident accident = new Accident(videoUrl, imageUrl, accidentDescription,
                                       accidentDescriptionText, accidentDescriptionTime,
                                       accidentDescriptionState);
        
        Accident savedAccident = accidentRepository.save(accident);
        return savedAccident.getId();
    }
    
    @Override
    public void updateDisplayInfo(Long id, String displayInfo) {
        Accident accident = accidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("事故信息不存在"));
        
        accident.setDisplayInfo(displayInfo);
        accidentRepository.save(accident);
    }
    
    @Override
    public Page<Accident> getAccidents(Pageable pageable) {
        return accidentRepository.findAll(pageable);
    }
    
    @Override
    public Accident getAccidentById(Long id) {
        return accidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("事故信息不存在"));
    }
    
    @Override
    public Map<String, Long> getAccidentStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalAccidents", accidentRepository.countTotalAccidents());
        stats.put("severeAccidents", accidentRepository.countSevereAccidents());
        stats.put("todayAccidents", accidentRepository.countTodayAccidents());
        return stats;
    }
}