package com.riwi.riwiPortalVirtual.infrasctructure.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.riwiPortalVirtual.Api.dto.request.lessonRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.basciMultimediaRespomse;
import com.riwi.riwiPortalVirtual.Api.dto.response.lessonResponse;
import com.riwi.riwiPortalVirtual.domain.entities.ClassRiwi;
import com.riwi.riwiPortalVirtual.domain.entities.lesson;
import com.riwi.riwiPortalVirtual.domain.repositories.ClassRiwiRepository;
import com.riwi.riwiPortalVirtual.domain.repositories.lessonRepository;
import com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service.ILessonsService;
import com.riwi.riwiPortalVirtual.utils.enums.Sortype;
import com.riwi.riwiPortalVirtual.utils.exceptions.BadRequestException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class LessonService implements ILessonsService{
    
    @Autowired
    private lessonRepository lessonRepository;

    @Autowired
    private ClassRiwiRepository classRepo;


    @Override
    public lessonResponse create(lessonRequest request) {
         lesson entity = this.requestToEntity(request);
        return this.responseToEntity(this.lessonRepository.save(entity));
    }

    @Override
    public lessonResponse get(Long id) {
        return this.responseToEntity(this.find(id));
    }

    @Override
    public lessonResponse update(lessonRequest request, Long id) {

        lesson less = this.find(id);
        
        less = this.requestToEntity(request);
        less.setId_lesson(id);
 
         return this.responseToEntity(this.lessonRepository.save(less));
    }

    @Override
    public void delete(Long id) {
        this.lessonRepository.delete(this.find(id));
    }

    @Override
    public Page<lessonResponse> getAll(int page, int size, Sortype sort) {

        if (page < 0)
        page = 0;

    PageRequest pagination = null;

    switch (sort) {
        case NONE -> pagination = PageRequest.of(page, size);
        case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
        case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }



    return this.lessonRepository.findByActiveTrue(pagination)
            .map(this::responseToEntity);
    }




    private lesson find(Long id) {
        return this.lessonRepository.findById(id)
            .orElseThrow(()-> new BadRequestException("No hay clases con el id suministrado"));
    }






       private lessonResponse responseToEntity(lesson entity) {

        basciMultimediaRespomse multimedResp = new basciMultimediaRespomse();
        BeanUtils.copyProperties(entity.getMultimedia(), multimedResp);
    
        return lessonResponse.builder()
        .id_lesson(entity.getId_lesson())
        .title(entity.getTitle())
        .content(entity.getContent())
        .create_at(entity.getCreate_at())
        .active(entity.isActive())
        .id_class(entity.getId_class())
        .multimedia(multimedResp)
        .build();
    }
    


    
    
    private lesson requestToEntity(lessonRequest request) {

        ClassRiwi claseRi = classRepo.findById(request.getId_class())
        .orElseThrow(() -> new BadRequestException("clase no encontrado"));

        return
        lesson.builder()
        .title(request.getTitle())
        .content(request.getContent())
        .active(request.isActive())
        .id_class(claseRi)
        .build();
    }



    
















}
