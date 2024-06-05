package com.riwi.riwiPortalVirtual.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity( name = "lesson")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class lesson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lesson;
    @Column(length = 255,nullable = false)
    private String title;
    @Lob
    private String content;
    @Builder.Default
    private LocalDateTime create_at = LocalDateTime.now();
    @Column(nullable = false)
    private boolean active;




}

