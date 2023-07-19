package ru.elseff.historymicro.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ru.elseff.historymicro.model.Question;
import ru.elseff.historymicro.service.QuestionService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuestionController {

    QuestionService questionService;

    @GetMapping("/questions")
    public List<Question> getRandomQuestions(@RequestParam(value = "amount", defaultValue = "2") Integer amount) {
        List<Question> questions = questionService.findAll();
        Collections.shuffle(questions);

        return questions
                .stream()
                .limit(amount)
                .collect(Collectors.toList());
    }

    @GetMapping("/questions/{id}")
    public Question findById(@PathVariable("id") Integer id){
        return questionService.findById(id)
                .orElseThrow(()->new IllegalArgumentException("question not found"));
    }

    @PostMapping("/questions")
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
