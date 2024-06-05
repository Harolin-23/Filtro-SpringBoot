package com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service;

import com.riwi.riwiPortalVirtual.Api.dto.request.studentRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.studenResponse;

public interface  IstudentsService extends CRUDservice<studentRequest, studenResponse,Long>{
    public final String FIELD_BY_SORT = "name";
}
