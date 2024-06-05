package com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service;

import com.riwi.riwiPortalVirtual.Api.dto.request.ClassRequest;
import com.riwi.riwiPortalVirtual.Api.dto.response.classResponse;

public interface IClassService extends CRUDservice<ClassRequest, classResponse,Long>{
    
    public final String FIELD_BY_SORT = "name";


}
