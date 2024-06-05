package com.riwi.riwiPortalVirtual.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.riwiPortalVirtual.domain.entities.lesson;

public interface lessonRepository extends  JpaRepository<lesson, Long>{
    
    public Page <lesson> findByActiveTrue(Pageable pageable);


}
