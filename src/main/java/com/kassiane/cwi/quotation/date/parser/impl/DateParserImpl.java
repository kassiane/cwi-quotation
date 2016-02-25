package com.kassiane.cwi.quotation.date.parser.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.kassiane.cwi.quotation.date.parser.DateParser;

public class DateParserImpl implements DateParser {

    private final Locale locale;

    public DateParserImpl(final Locale locale) {
        this.locale = locale;
    }

    @Override
    public Date parseDate(final String date) throws ParseException {
        final DateFormat format = new SimpleDateFormat(DATE_FORMAT, this.locale);
        format.setLenient(false);
        return format.parse(date);
    }
}
