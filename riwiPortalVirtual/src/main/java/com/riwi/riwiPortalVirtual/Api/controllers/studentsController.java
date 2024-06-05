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

import com.riwi.riwiPortalVirtual.Api.dto.request.studentRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.studenResponse;
import com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service.IstudentsService;
import com.riwi.riwiPortalVirtual.utils.enums.Sortype;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "studentsPath")
@AllArgsConstructor
public class studentsController {
    
    private final IstudentsService Studentservice;



    @GetMapping
    public ResponseEntity<Page<studenResponse>> getAll(
     @RequestParam(defaultValue = "1") int page,
     @RequestParam(defaultValue = "10") int size,
     @RequestHeader(required = false) Sortype sortType) 
      {
        if (Objects.isNull(sortType))
            sortType = Sortype.NONE;
        return ResponseEntity.ok(this.Studentservice.getAll(page - 1, size, sortType));
    }


    @PostMapping
    public ResponseEntity<studenResponse> insert(@Validated @RequestBody studentRequest request) {
        studenResponse response = Studentservice.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<studenResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.Studentservice.get(id));
    }
    @PatchMapping(path = "/{id}/disable")
        public ResponseEntity<studenResponse> update(@Validated @RequestBody studentRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.Studentservice.update(request, id));
    }







}
