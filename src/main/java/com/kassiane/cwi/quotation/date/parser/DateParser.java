package com.kassiane.cwi.quotation.date.parser;

import java.text.ParseException;
import java.util.Date;

/**
 * Interface of Date Parser.
 * 
 * @author kassi
 *
 */
public interface DateParser {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    Date parseDate(String date) throws ParseException;

}