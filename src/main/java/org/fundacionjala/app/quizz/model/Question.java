package org.fundacionjala.app.quizz.model;

import java.util.ArrayList;
import java.util.List;

import org.fundacionjala.app.quizz.model.validator.ValidatorType;

public class Question {

    private final String title;
    private final QuestionType questionType;
    private final List<ValidatorType> validations;
    private final List<String> additionalData;

    private Question(String title, QuestionType questionType, List<ValidatorType> validations) {
        this.title = title;
        this.questionType = questionType;
        this.validations = validations;
        additionalData = new ArrayList<>();
    }

    public List<ValidatorType> getValidations() {
        return validations;
    }

    public String getTitle() {
        return title;
    }

    public QuestionType getType() {
        return questionType;
    }

    public List<String> getAdditionalData() {
        return additionalData;
    }

    public static class QuestionBuilder {
        private String title;
        private QuestionType questionType;
        private List<ValidatorType> validations;
        private List<String> additionalData;

        public QuestionBuilder(String title, QuestionType questionType) {
            this.title = title;
            this.questionType = questionType;
            this.validations = new ArrayList<>();
            this.additionalData = new ArrayList<>();
        }

        public List<ValidatorType> getValidations() {
            return validations;
        }

        public boolean addValidation(ValidatorType validation) {
            if (validations.contains(validation)) {
                return false;
            }

            validations.add(validation);
            return true;
        }

        public void setAdditionalData(List<String> additionalData) {
            this.additionalData = additionalData;
        }

        public Question build() {
            Question question = new Question(title, questionType, validations);
            if (additionalData.size() > 0) {
                question.additionalData.addAll(additionalData);
            }

            return question;
        }
    }
}
