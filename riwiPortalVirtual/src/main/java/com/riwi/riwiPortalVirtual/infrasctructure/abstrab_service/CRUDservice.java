package com.riwi.riwiPortalVirtual.infrasctructure.abstrab_service;

import org.springframework.data.domain.Page;

import com.riwi.riwiPortalVirtual.utils.enums.Sortype;

public interface CRUDservice <RQ,RS,ID>{
    public RS create(RQ request);

        public RS get(ID id);

        public RS update(RQ request, ID id);

        public void delete(ID id);

        public Page<RS> getAll(int page, int size, Sortype sort);
}
