package com.riwi.riwiPortalVirtual.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.riwiPortalVirtual.domain.entities.student;

public interface  studenRepository extends  JpaRepository<student, Long>{
    
    public Page <student> findByActiveTrue(Pageable pageable);





    

}
