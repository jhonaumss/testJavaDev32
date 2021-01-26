package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class OnlyUpperCaseTextValidator implements Validator<String, String> {

    private static final String ERROR_MESSAGE = "The format is invalid, it should have only Upper Case Letters";
    @Override
    public void validate(String value, String conditionValue, List<String> errors) {
        if (!value.toUpperCase().equals(value)){
            errors.add(ERROR_MESSAGE);
        }
    }
}
