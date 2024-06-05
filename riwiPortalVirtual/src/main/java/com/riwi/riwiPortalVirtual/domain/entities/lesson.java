package com.riwi.riwiPortalVirtual.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private long id_lesson;
    @Column(length = 255,nullable = false)
    private String title;
    @Lob
    private String content;
    @Builder.Default
    private LocalDateTime create_at = LocalDateTime.now();
    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "id_class", nullable = true)
    private ClassRiwi id_class;

    @OneToMany(mappedBy = "id_lesson", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonManagedReference
    private List<multimed> multimedia;

  



}

