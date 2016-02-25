package com.kassiane.cwi.quotation.mock;

import java.text.ParseException;
import java.util.Date;

import com.kassiane.cwi.quotation.checker.DateParser;

public class DateParserMock implements DateParser {

    private final Date givenDate;

    public DateParserMock(final Date givenDate) {
        this.givenDate = givenDate;
    }

    @Override
    public Date parseDate(final String date) throws ParseException {
        return this.givenDate;
    }

}