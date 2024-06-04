package com.riwi.Filtro_Spring_Boot.api.dto.response;

import java.util.List;

public class QuestionResponse {
    private Long id;
    private String text;
    private String type;
    private boolean active;
    private List<OptionsQuestionResponse> optionsQuestion;
}