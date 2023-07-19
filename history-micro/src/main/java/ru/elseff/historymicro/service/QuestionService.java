package ru.elseff.historymicro.service;

import ru.elseff.historymicro.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> findAll();

    Optional<Question> findById(Integer id);

    Question addQuestion(Question question);
}
