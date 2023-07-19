package ru.elseff.mathmicro.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.elseff.mathmicro.model.Question;

import java.util.Random;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MathServiceImpl implements MathService {

    final Random random;

    @Value("${max.operand.value}")
    Integer maxOperandValue;

    @Override
    public Question getRandom() {
        int a = random.nextInt(maxOperandValue);
        int b = random.nextInt(maxOperandValue);

        int randomOperationNumber = random.nextInt(3);

        char operation = switch (randomOperationNumber) {
            case 0 -> '+';
            case 1 -> '-';
            case 2 -> '*';
            default -> throw new IllegalStateException("Unexpected value: " + randomOperationNumber);
        };

        String question = String.valueOf(a) +
                operation +
                b +
                "=?";

        String answer = switch (operation) {
            case '+' -> String.valueOf(a + b);
            case '-' -> String.valueOf(a - b);
            case '*' -> String.valueOf(a * b);
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };

        return Question.builder()
                .question(question)
                .answer(answer)
                .build();
    }
}
