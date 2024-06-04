package com.riwi.Filtro_Spring_Boot.infrastructure.abstract_services;

import com.riwi.Filtro_Spring_Boot.api.dto.request.UserRequest;
import com.riwi.Filtro_Spring_Boot.api.dto.response.UserResponse;

public interface IUserService extends  CrudService<UserRequest, UserResponse, Long>{
}
