package com.parent.springai.intellidetect.repository;

import com.parent.springai.intellidetect.entity.Accident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {
    
    @Query("SELECT COUNT(a) FROM Accident a")
    Long countTotalAccidents();
    
    @Query("SELECT COUNT(a) FROM Accident a WHERE a.accidentDescriptionState LIKE '%严重%'")
    Long countSevereAccidents();
    
    @Query("SELECT COUNT(a) FROM Accident a WHERE DATE(a.createdTime) = CURRENT_DATE")
    Long countTodayAccidents();
    
    Page<Accident> findAll(Pageable pageable);
}