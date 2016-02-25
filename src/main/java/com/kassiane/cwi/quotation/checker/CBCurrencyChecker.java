package com.kassiane.cwi.quotation.checker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CBCurrencyChecker {

    private final String negativeValue = "Value must not be negative or zero.";
    private final String wrongDateFormat = "Date format must be dd/MM/yyyy.";
    private final String nullDate = "Date must not be null.";
    private final DateFormat datePattern = new SimpleDateFormat("dd/MM/yyyy");

    public boolean checkMonetaryValue(final float value) {
        if (value <= 0) {
            throw new IllegalArgumentException(this.negativeValue);
        }
        return true;
    }

    public boolean checkDate(final String dateToCheck) {
        if (dateToCheck == null)
            throw new IllegalArgumentException(this.nullDate);
        try {
            this.datePattern.setLenient(false);
            this.datePattern.parse(dateToCheck);
        } catch (final ParseException e) {
            throw new IllegalArgumentException(this.wrongDateFormat, e);
        }
        return true;
    }
}
