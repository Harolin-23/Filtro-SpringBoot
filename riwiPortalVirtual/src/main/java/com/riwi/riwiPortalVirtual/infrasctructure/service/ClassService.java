package com.riwi.riwiPortalVirtual.infrasctructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.riwiPortalVirtual.Api.dto.request.ClassRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.classResponse;
import com.riwi.riwiPortalVirtual.domain.entities.ClassRiwi;
import com.riwi.riwiPortalVirtual.domain.repositories.ClassRiwiRepository;
import com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service.IClassService;
import com.riwi.riwiPortalVirtual.utils.enums.Sortype;
import com.riwi.riwiPortalVirtual.utils.exceptions.BadRequestException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ClassService implements  IClassService{
    
    @Autowired
    private ClassRiwiRepository classRepository;



    @Override
    public classResponse create(ClassRequest request) {
        ClassRiwi entity = this.requestToEntity(request);
        return this.responseToEntity(this.classRepository.save(entity));
    }

    @Override
    public classResponse get(Long id) {
        return this.responseToEntity(this.find(id));
    }

    @Override
    public classResponse update(ClassRequest request, Long id) {

        ClassRiwi classR = this.find(id);
        
        classR = this.requestToEntity(request);
        classR.setId_class(id);
 
         return this.responseToEntity(this.classRepository.save(classR));
    }

    @Override
    public void delete(Long id) {
        this.classRepository.delete(this.find(id));

    }


    @Override
    public Page<classResponse> getAll(int page, int size, Sortype sort) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sort) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        


        return this.classRepository.findByActiveTrue(pagination)
                .map(this::responseToEntity);
    }


    private ClassRiwi find(Long id) {
        return this.classRepository.findById(id)
            .orElseThrow(()-> new BadRequestException("No hay clases con el id suministrado"));
    }

     private classResponse responseToEntity(ClassRiwi entity) {
    
        return classResponse.builder()
        .id_class(entity.getId_class())
        .name(entity.getName())
        .description(entity.getDescription())
        .create_at(entity.getCreate_at())
        .active(entity.isActive())
        .build();
    }
    

    private ClassRiwi requestToEntity(ClassRequest request) {
        return ClassRiwi.builder()
        .name(request.getName())
        .description(request.getDescription())
        .active(request.isActive())
        .build();
    }

   








    
}
