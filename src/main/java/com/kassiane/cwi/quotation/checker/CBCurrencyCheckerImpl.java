package com.kassiane.cwi.quotation.checker;

import java.text.ParseException;

public class CBCurrencyCheckerImpl implements CBCurrencyChecker {

    private static final String NEGATIVE_VALUE = "Value must not be negative or zero.";
    private static final String WRONG_DATE_FORMAT = "Date format must be " + DateParser.DATE_FORMAT + ".";
    private static final String NULL_DATE = "Date must not be null.";

    private final DateParser dateParser;

    public CBCurrencyCheckerImpl(final DateParser dateParser) {
        this.dateParser = dateParser;
    }

    @Override
    public boolean checkMonetaryValue(final float value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NEGATIVE_VALUE);
        }
        return true;
    }

    @Override
    public boolean checkDate(final String dateToCheck) {
        if (dateToCheck == null)
            throw new IllegalArgumentException(NULL_DATE);
        try {
            this.dateParser.parseDate(dateToCheck);
        } catch (final ParseException e) {
            throw new IllegalArgumentException(WRONG_DATE_FORMAT, e);
        }
        return true;
    }
}
