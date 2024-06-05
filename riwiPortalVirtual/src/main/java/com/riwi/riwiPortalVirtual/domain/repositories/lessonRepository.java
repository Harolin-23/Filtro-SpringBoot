package com.riwi.riwiPortalVirtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.riwiPortalVirtual.domain.entities.lesson;

public interface lessonRepository extends  JpaRepository<lesson, Long>{
    
}
