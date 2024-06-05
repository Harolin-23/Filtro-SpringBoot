package com.riwi.riwiPortalVirtual.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity( name = "student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class student {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_student;
    @Column(length = 255,nullable = false)
    private String name;
    @Column(length = 255,nullable = false)
    private String email;
    @Builder.Default
    private LocalDateTime create_at = LocalDateTime.now();
    @Column(nullable = false)
    private boolean active;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_class", nullable = true)
    private ClassRiwi id_class;


    
}
