package com.parent.springai.intellidetect.controller;

import com.parent.springai.intellidetect.dto.AccidentDTO;
import com.parent.springai.intellidetect.dto.DisplayInfoDTO;
import com.parent.springai.intellidetect.entity.Accident;
import com.parent.springai.intellidetect.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/accidents")
@CrossOrigin(origins = "*")
public class AccidentController {
    
    @Autowired
    private AccidentService accidentService;
    
    @PostMapping
    public ResponseEntity<Map<String, Object>> createAccident(@RequestBody AccidentDTO accidentDTO) {
        try {
            Long accidentId = accidentService.createAccident(
                accidentDTO.getVideoUrl(),
                accidentDTO.getImageUrl(),
                accidentDTO.getAccidentDescription(),
                accidentDTO.getAccidentDescriptionText(),
                accidentDTO.getAccidentDescriptionTime(),
                accidentDTO.getAccidentDescriptionState()
            );
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "创建成功");
            
            Map<String, Object> data = new HashMap<>();
            data.put("id", accidentId);
            response.put("data", data);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @PutMapping("/{id}/display")
    public ResponseEntity<Map<String, Object>> updateDisplayInfo(@PathVariable Long id, 
                                                               @RequestBody DisplayInfoDTO displayInfoDTO) {
        try {
            accidentService.updateDisplayInfo(id, displayInfoDTO.getDisplayInfo());
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "更新成功");
            
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
    public ResponseEntity<Map<String, Object>> getAccidents(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page - 1, size);
            Page<Accident> accidentPage = accidentService.getAccidents(pageable);
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "查询成功");
            
            Map<String, Object> data = new HashMap<>();
            data.put("total", accidentPage.getTotalElements());
            data.put("records", accidentPage.getContent());
            data.put("page", page);
            data.put("size", size);
            data.put("totalPages", accidentPage.getTotalPages());
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
    public ResponseEntity<Map<String, Object>> getAccidentById(@PathVariable Long id) {
        try {
            Accident accident = accidentService.getAccidentById(id);
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", accident);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getAccidentStats() {
        try {
            Map<String, Long> stats = accidentService.getAccidentStats();
            
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
}