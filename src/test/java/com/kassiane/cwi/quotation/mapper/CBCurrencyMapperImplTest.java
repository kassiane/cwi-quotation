package com.kassiane.cwi.quotation.mapper;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import com.kassiane.cwi.quotation.date.parser.DateParser;
import com.kassiane.cwi.quotation.domain.CBCurrency;
import com.kassiane.cwi.quotation.mapper.impl.CBCurrencyMapperImpl;
import com.kassiane.cwi.quotation.mock.DateParserMock;

/**
 * Test of class {@link CBCurrencyMapperImpl}.
 *
 * @author kassi
 *
 */
public class CBCurrencyMapperImplTest {

    @Test
    public void shouldMapCurrencyCorrectly() throws IllegalArgumentException, ParseException {
        // given
        final String given = "23/02/2016;123;A;EUR;3,1415;2,1515;3,1415;2,1515";
        final Calendar givenCalendar = new GregorianCalendar();
        givenCalendar.set(2016, 01, 23);
        final DateParser dateParser = new DateParserMock(givenCalendar.getTime());
        final CBCurrencyMapper subject = new CBCurrencyMapperImpl(dateParser);
        // when
        final CBCurrency mappedCurrency = subject.mapCBCurrency(given.split(";"));
        final Calendar mappedCurrencyCalendar = new GregorianCalendar();
        mappedCurrencyCalendar.setTime(mappedCurrency.getDate());
        // then
        Assert.assertTrue("EUR".equals(mappedCurrency.getName()));
        Assert.assertTrue("123".equals(mappedCurrency.getCode()));
        Assert.assertTrue("A".equals(mappedCurrency.getType()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnErrorWhenWrongNumberOfColumns() throws IllegalArgumentException, ParseException {
        // given
        final String given = "23/02/2016;123;A";
        final Calendar givenCalendar = new GregorianCalendar();
        givenCalendar.set(2016, 01, 23);
        final DateParser dateParser = new DateParserMock(givenCalendar.getTime());
        final CBCurrencyMapper subject = new CBCurrencyMapperImpl(dateParser);
        // when
        subject.mapCBCurrency(given.split(";"));
        // then (expected = IllegalArgumentException.class)
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorWhenMonetaryNumberInInvalidFormat() throws IllegalArgumentException, ParseException {
        // given
        final String given = "23/02/2016;123;A;EUR;a.234;2,1515;3,1415;2,1515";
        final Calendar givenCalendar = new GregorianCalendar();
        givenCalendar.set(2016, 01, 23);
        final DateParser dateParser = new DateParserMock(givenCalendar.getTime());
        final CBCurrencyMapper subject = new CBCurrencyMapperImpl(dateParser);
        // when
        subject.mapCBCurrency(given.split(";"));
        // then (expected = ParseException.class)
    }
}