package com.riwi.riwiPortalVirtual.Api.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.riwiPortalVirtual.Api.dto.request.lessonRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.lessonResponse;
import com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service.ILessonsService;
import com.riwi.riwiPortalVirtual.utils.enums.Sortype;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "lessonPath")
@AllArgsConstructor
public class lessonController {


    private final ILessonsService lessonService;

    @GetMapping
    public ResponseEntity<Page<lessonResponse>> getAll(
     @RequestParam(defaultValue = "1") int page,
     @RequestParam(defaultValue = "10") int size,
     @RequestHeader(required = false) Sortype sortType) 
      {
        if (Objects.isNull(sortType))
            sortType = Sortype.NONE;
        return ResponseEntity.ok(this.lessonService.getAll(page - 1, size, sortType));
    }


    @PostMapping
    public ResponseEntity<lessonResponse> insert(@Validated @RequestBody lessonRequest request) {
        lessonResponse response = lessonService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<lessonResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.lessonService.get(id));
    }

      @PatchMapping(path = "/{id}/disable")
        public ResponseEntity<lessonResponse> update(@Validated @RequestBody lessonRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.lessonService.update(request, id));
    }










}
