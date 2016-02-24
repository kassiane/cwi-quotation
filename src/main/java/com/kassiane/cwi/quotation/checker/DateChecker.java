package com.kassiane.cwi.quotation.checker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateChecker {

    private final Locale locale;

    public DateChecker(final Locale locale) {
        this.locale = locale;
    }

    public Date parseDate(final String date) {

        final DateFormat format = new SimpleDateFormat("dd/MM/yyyy", this.locale);
        Date dateD = null;
        try {
            dateD = format.parse(date);
        } catch (final ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dateD;
    }
}
