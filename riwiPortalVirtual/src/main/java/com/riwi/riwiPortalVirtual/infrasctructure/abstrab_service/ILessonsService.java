package com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service;

import com.riwi.riwiPortalVirtual.Api.dto.request.lessonRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.lessonResponse;

public interface  ILessonsService extends CRUDservice<lessonRequest, lessonResponse,Long>{
    public final String FIELD_BY_SORT = "title";
}
