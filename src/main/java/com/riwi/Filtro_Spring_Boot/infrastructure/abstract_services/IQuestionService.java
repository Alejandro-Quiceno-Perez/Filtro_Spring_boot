package com.riwi.Filtro_Spring_Boot.infrastructure.abstract_services;

import com.riwi.Filtro_Spring_Boot.api.dto.request.QuestionRequest;
import com.riwi.Filtro_Spring_Boot.api.dto.response.QuestionResponse;

public interface IQuestionService extends CrudService<QuestionRequest, QuestionResponse, Long>{
}
