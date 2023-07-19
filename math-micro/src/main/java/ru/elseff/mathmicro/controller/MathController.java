package ru.elseff.mathmicro.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.elseff.mathmicro.model.Question;
import ru.elseff.mathmicro.service.MathService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MathController {

    MathService mathService;

    @GetMapping("/questions")
    public List<Question> getRandomQuestions(@RequestParam(value = "amount", defaultValue = "10") Integer amount) {
        return IntStream
                .range(0, amount)
                .mapToObj(a -> mathService.getRandom())
                .collect(Collectors.toList());
    }
}
