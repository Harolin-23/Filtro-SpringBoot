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
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity( name = "Class")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRiwi {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id_class;
    @Column(length = 255,nullable = false)
    private String name;
    @Lob
    private String description;
    @Builder.Default
    private LocalDateTime create_at = LocalDateTime.now();
    @Column(nullable = false)
    private boolean active;


    
    @OneToMany(mappedBy = "id_class", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<student> students;




    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "id_class", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<lesson> lessons;





    

}
