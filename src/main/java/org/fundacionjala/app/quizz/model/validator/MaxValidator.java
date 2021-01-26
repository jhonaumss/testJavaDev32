package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class MaxValidator implements Validator<Integer, Integer> {
    private static final String ERROR_MESSAGE = "The value must be less than ";
    @Override
    public void validate(Integer value, Integer conditionValue, List<String> errors) {
        if (value > conditionValue) {
            errors.add(ERROR_MESSAGE + conditionValue);
        }
    }
}
