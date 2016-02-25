package com.kassiane.cwi.quotation.date.parser;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kassiane.cwi.quotation.date.parser.DateParser;
import com.kassiane.cwi.quotation.date.parser.impl.DateParserImpl;

/**
 * Test of class {@link DateParserImpl}.
 *
 * @author kassi
 *
 */
public class DateParserImplTest {

    private static DateParser subject;

    @BeforeClass
    public static void setUp() {
        subject = new DateParserImpl(new Locale("pt", "BR"));
    }

    @Test
    public void shouldParseDateCorrectly() throws ParseException {
        // given
        final String given = "23/02/2016";
        final Calendar givenCalendar = new GregorianCalendar();
        givenCalendar.set(2016, 01, 23);
        // when
        final Date date = subject.parseDate(given);
        final Calendar returnedCalendar = new GregorianCalendar();
        returnedCalendar.setTime(date);
        // then
        Assert.assertEquals(givenCalendar.get(Calendar.YEAR), returnedCalendar.get(Calendar.YEAR));
        Assert.assertEquals(givenCalendar.get(Calendar.MONTH), returnedCalendar.get(Calendar.MONTH));
        Assert.assertEquals(givenCalendar.get(Calendar.DAY_OF_MONTH), returnedCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test(expected = ParseException.class)
    public void shoudlReturnErrorWhenMonthGreaterThanPossible() throws ParseException {
        // given
        final String given = "23/22/2016";
        final Calendar givenCalendar = new GregorianCalendar();
        givenCalendar.set(2016, 01, 23);
        // when
        final Date date = subject.parseDate(given);
        final Calendar returnedCalendar = new GregorianCalendar();
        returnedCalendar.setTime(date);
        // then (expected = ParseException.class)
    }

    @Test(expected = ParseException.class)
    public void shoudlReturnErrorWhenDayGreaterThanPossibleInMonth() throws ParseException {
        // given
        final String given = "30/02/2016";
        final Calendar givenCalendar = new GregorianCalendar();
        givenCalendar.set(2016, 01, 23);
        // when
        final Date date = subject.parseDate(given);
        final Calendar returnedCalendar = new GregorianCalendar();
        returnedCalendar.setTime(date);
        // then (expected = ParseException.class)
    }

    @Test(expected = ParseException.class)
    public void shoudlReturnErrorWhenDateWithoutSlash() throws ParseException {
        // given
        final String given = "10022016";
        final Calendar givenCalendar = new GregorianCalendar();
        givenCalendar.set(2016, 01, 23);
        // when
        final Date date = subject.parseDate(given);
        final Calendar returnedCalendar = new GregorianCalendar();
        returnedCalendar.setTime(date);
        // then (expected = ParseException.class)
    }

}
