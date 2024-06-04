package com.riwi.Filtro_Spring_Boot.infrastructure.services;

import com.riwi.Filtro_Spring_Boot.api.dto.request.QuestionRequest;
import com.riwi.Filtro_Spring_Boot.api.dto.response.QuestionResponse;
import com.riwi.Filtro_Spring_Boot.domain.entities.Question;
import com.riwi.Filtro_Spring_Boot.domain.repositories.QuestionRepository;
import com.riwi.Filtro_Spring_Boot.infrastructure.abstract_services.IQuestionService;
import com.riwi.Filtro_Spring_Boot.util.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    @Override
    public Page<QuestionResponse> getAll(int page, int size, SortType sortType) {
        return null;
    }

    @Override
    public QuestionResponse getById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public QuestionResponse update(QuestionRequest questionRequest, Long aLong) {
        return null;
    }

    @Override
    public QuestionResponse create(QuestionRequest questionRequest) {
        return null;
    }

    private Question requestToEntity(QuestionRequest request) {
        Question question = new Question();
        BeanUtils.copyProperties(request,question);
        return question;
    }

    private QuestionResponse entityToResponse(Question question) {
        QuestionResponse questionResponse = new QuestionResponse();
        BeanUtils.copyProperties(question,questionResponse);
        questionResponse.toString(question);

    }
}
