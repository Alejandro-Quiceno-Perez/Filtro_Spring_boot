package com.riwi.Filtro_Spring_Boot.infrastructure.abstract_services;

import com.riwi.Filtro_Spring_Boot.util.enums.SortType;
import org.springframework.data.domain.Page;

public interface CrudService <Request, Response,Id>{
    Page<Response> getAll (int page, int size, SortType sortType);
    Response getById(Id id);
    Response create(Request request);
    Response update(Request request, Id id);
    void delete (Id id);
}
