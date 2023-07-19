package ru.elseff.historymicro.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.elseff.historymicro.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
