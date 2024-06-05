package com.riwi.riwiPortalVirtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.riwiPortalVirtual.domain.entities.student;

public interface  studenRepository extends  JpaRepository<student, Long>{
    
}
