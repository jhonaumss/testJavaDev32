package org.fundacionjala.app.quizz.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private final String title;
    private final List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
