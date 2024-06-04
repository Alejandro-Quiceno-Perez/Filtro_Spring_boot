package com.riwi.Filtro_Spring_Boot.domain.repositories;

import com.riwi.Filtro_Spring_Boot.domain.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question, Long>{
}
