package org.fundacionjala.app.quizz.model.configuration;

import java.text.SimpleDateFormat;

import org.fundacionjala.app.quizz.model.validator.ValidatorType;

public class DateConfiguration extends QuestionConfiguration {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

    public DateConfiguration() {
        super(false, ValidatorType.REQUIRED, ValidatorType.DATE);
    }

    @Override
    public String convertValue(String value) {
        return FORMATTER.format(value);
    }
}
