package com.riwi.riwiPortalVirtual.infrasctructure.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.riwiPortalVirtual.Api.dto.request.studentRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.basicClassResponse;
import com.riwi.riwiPortalVirtual.Api.dto.response.studenResponse;
import com.riwi.riwiPortalVirtual.domain.entities.ClassRiwi;
import com.riwi.riwiPortalVirtual.domain.entities.student;
import com.riwi.riwiPortalVirtual.domain.repositories.ClassRiwiRepository;
import com.riwi.riwiPortalVirtual.domain.repositories.studenRepository;
import com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service.IstudentsService;
import com.riwi.riwiPortalVirtual.utils.enums.Sortype;
import com.riwi.riwiPortalVirtual.utils.exceptions.BadRequestException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class studentsService implements IstudentsService{

    @Autowired
    private studenRepository studentsRepository;

    @Autowired
    private ClassRiwiRepository classRepository;


    @Override
    public studenResponse create(studentRequest request) {
        student entity = this.requestToEntity(request);
        return this.responseToEntity(this.studentsRepository.save(entity));
    }

    @Override
    public studenResponse get(Long id) {
        return this.responseToEntity(this.find(id));
    }




    @Override
    public studenResponse update(studentRequest request, Long id) {
        student student = this.find(id);
        
        student = this.requestToEntity(request);
        student.setId_student(id);
 
         return this.responseToEntity(this.studentsRepository.save(student));
    }

    @Override
    public void delete(Long id) {
        this.studentsRepository.delete(this.find(id));
    }

    @Override
    public Page<studenResponse> getAll(int page, int size, Sortype sort) {

            if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sort) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
    

        return this.studentsRepository.findByActiveTrue(pagination)
                .map(this::responseToEntity);
    }

    private student find(Long id) {
        return this.studentsRepository.findById(id)
            .orElseThrow(()-> new BadRequestException("No hay clases con el id suministrado"));
    }


     private studenResponse responseToEntity(student entity) {

        basicClassResponse classeResp = new basicClassResponse();
        BeanUtils.copyProperties(entity.getId_class(), classeResp);

    
        return studenResponse.builder()
        .id_student(entity.getId_student())
        .name(entity.getName())
        .email(entity.getEmail())
        .create_at(entity.getCreate_at())
        .active(entity.isActive())
        .id_class(classeResp)
        .build();
    }


      private student requestToEntity(studentRequest request) {

        ClassRiwi clase = classRepository.findById(request.getId_class()).orElseThrow(() -> new BadRequestException("clase no encontrado"));

        return

        student.builder()
        .name(request.getName())
        .email(request.getEmail())
        .id_class(clase)
        .active(request.isActive())
        .build();
    }

    




}
