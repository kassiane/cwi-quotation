package com.kassiane.cwi.quotation.checker.impl;

import java.text.ParseException;

import com.kassiane.cwi.quotation.checker.CBCurrencyChecker;
import com.kassiane.cwi.quotation.date.parser.DateParser;

/**
 * Implementation of {@link CBCurrencyChecker}. Entity that checks if given
 * parameters are valid.
 *
 * @author kassi
 *
 */
public class CBCurrencyCheckerImpl implements CBCurrencyChecker {

    private static final String NEGATIVE_VALUE = "Value must not be negative or zero: ";
    private static final String WRONG_DATE_FORMAT = "Date format must be: " + DateParser.DATE_FORMAT + ".";
    private static final String NULL_DATE = "Date must not be null.";
    private static final String NULL_NAME = "Currency name must not be null.";
    private static final String EMPTY_NAME = "Currency name must not be empty.";

    private final DateParser dateParser;

    public CBCurrencyCheckerImpl(final DateParser dateParser) {
        this.dateParser = dateParser;
    }

    @Override
    public boolean checkMonetaryValue(final float value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NEGATIVE_VALUE + value);
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

    @Override
    public boolean checkName(final String nameToCheck) {
        if (nameToCheck == null)
            throw new IllegalArgumentException(NULL_NAME);
        if (nameToCheck.trim().isEmpty())
            throw new IllegalArgumentException(EMPTY_NAME);
        return true;
    }
}
