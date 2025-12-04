package com.parent.springai.intellidetect.repository;

import com.parent.springai.intellidetect.entity.Obstacle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ObstacleRepository extends JpaRepository<Obstacle, Long> {
    
    @Query("SELECT COUNT(o) FROM Obstacle o")
    Long countTotalObstacles();
    
    @Query("SELECT COUNT(o) FROM Obstacle o WHERE o.riskLevel = 'high'")
    Long countHighRiskObstacles();
    
    @Query("SELECT COUNT(o) FROM Obstacle o WHERE DATE(o.detectionTime) = CURRENT_DATE")
    Long countTodayObstacles();
    
    @Query("SELECT COUNT(o) FROM Obstacle o WHERE o.status = 'pending'")
    Long countPendingObstacles();
    
    @Query("SELECT COUNT(o) FROM Obstacle o WHERE o.status = 'resolved'")
    Long countResolvedObstacles();
    
    Page<Obstacle> findAll(Pageable pageable);
    
    List<Obstacle> findByRiskLevelOrderByDetectionTimeDesc(String riskLevel);
    
    @Query("SELECT o FROM Obstacle o WHERE o.riskLevel = 'high' ORDER BY o.detectionTime DESC")
    List<Obstacle> findHighRiskObstacles();
}