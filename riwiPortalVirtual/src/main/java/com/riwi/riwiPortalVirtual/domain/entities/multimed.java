package com.riwi.riwiPortalVirtual.domain.entities;

import java.time.LocalDateTime;

import com.riwi.riwiPortalVirtual.utils.enums.typeDateEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity( name = "multimedia")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class multimed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_multimedy;
    
    @Enumerated(EnumType.STRING)
    private typeDateEnum type;
    @Lob
    private String url;
    @Builder.Default
    private LocalDateTime create_at = LocalDateTime.now();
    @Column(nullable = false)
    private boolean active;

 
    
    @ManyToOne
    @JoinColumn(name = "id_lesson", nullable = true)
    private lesson id_lesson;


}
