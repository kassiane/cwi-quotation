package com.kassiane.cwi.quotation.checker;

import java.text.ParseException;
import java.util.Date;

public interface DateParser {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    Date parseDate(String date) throws ParseException;

}