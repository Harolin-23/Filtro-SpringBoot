package com.riwi.riwiPortalVirtual.Api.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.riwiPortalVirtual.Api.dto.request.ClassRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.classResponse;
import com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service.IClassService;
import com.riwi.riwiPortalVirtual.infrasctructure.service.ClassService;
import com.riwi.riwiPortalVirtual.utils.enums.Sortype;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "classPath")
@AllArgsConstructor
public class classController {

    private final IClassService classService;
    private final ClassService serviceGen;


    
    @GetMapping
    public ResponseEntity<Page<classResponse>> getAll(
     @RequestParam(defaultValue = "1") int page,
     @RequestParam(defaultValue = "10") int size,
     @RequestHeader(required = false) Sortype sortType) 
      {
        if (Objects.isNull(sortType))
            sortType = Sortype.NONE;
        return ResponseEntity.ok(this.classService.getAll(page - 1, size, sortType));
    }


    @PostMapping
    public ResponseEntity<classResponse> insert(@Validated @RequestBody ClassRequest request) {
        classResponse response = classService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<classResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.classService.get(id));
    }








}
