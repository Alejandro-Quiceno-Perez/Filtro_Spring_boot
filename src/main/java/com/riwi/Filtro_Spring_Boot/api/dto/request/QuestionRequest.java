package com.riwi.Filtro_Spring_Boot.api.dto.request;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    @NotBlank(message = "Este campo es requerido")
    private String text;

    @NotBlank(message = "Este campo es requerido")
    private String type;

    @NotBlank(message = "Este campo es requerido")
    private boolean active;
}
