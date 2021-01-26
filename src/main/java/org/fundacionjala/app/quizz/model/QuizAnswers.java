package org.fundacionjala.app.quizz.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuizAnswers {

    private final Quiz quiz;
    private final UUID id;
    private final List<Answer> answers;

    public QuizAnswers(Quiz quiz) {
        this.quiz = quiz;
        this.id = UUID.randomUUID();
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public UUID getId() {
        return id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
