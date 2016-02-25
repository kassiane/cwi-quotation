package com.kassiane.cwi.quotation.currency.parser;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import com.kassiane.cwi.quotation.currency.data.provider.CBCurrencyDataProvider;
import com.kassiane.cwi.quotation.currency.parser.impl.CBCurrencyParserImpl;
import com.kassiane.cwi.quotation.domain.CBCurrency;
import com.kassiane.cwi.quotation.exception.CurrencyNotAvailableException;
import com.kassiane.cwi.quotation.mapper.CBCurrencyMapper;
import com.kassiane.cwi.quotation.mock.CBCurrencyMapperMock;

/**
 * Test of class {@link CBCurrencyParser}.
 *
 * @author kassi
 *
 */
public class CBCurrencyParserTest {

    @Test
    public void shouldListAllCurrenciesCorrectly() throws IOException, ParseException {
        // given
        final CBCurrencyDataProvider cbcurrencyDataProvider = new CBCurrencyDataProvider();
        final Map<String, CBCurrency> given = cbcurrencyDataProvider.generateCbcurrencyList(3);
        final String data = cbcurrencyDataProvider.generateData(given);
        final CBCurrencyMapper cbcurrencyMapper = new CBCurrencyMapperMock(given);
        final CBCurrencyParser subject = new CBCurrencyParserImpl(cbcurrencyMapper);
        // when
        final Map<String, CBCurrency> returnedMap = subject.listAll(data);
        // then
        for (final Entry<String, CBCurrency> entry : given.entrySet()) {
            final String key = entry.getKey();
            final CBCurrency value = entry.getValue();
            Assert.assertTrue(returnedMap.containsKey(key));
            Assert.assertTrue(returnedMap.containsValue(value));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnAnErrorWhenNoData() throws IOException, ParseException {
        // given
        final CBCurrencyDataProvider cbcurrencyDataProvider = new CBCurrencyDataProvider();
        final Map<String, CBCurrency> given = cbcurrencyDataProvider.generateCbcurrencyList(0);
        final CBCurrencyMapper cbcurrencyMapper = new CBCurrencyMapperMock(given);
        final CBCurrencyParser subject = new CBCurrencyParserImpl(cbcurrencyMapper);
        // when
        subject.listAll(null).toString();
        // then (expected = IllegalArgumentException.class)
    }

    @Test
    public void shouldReturnCurrencyCorrectly() throws IOException, ParseException {
        // given
        final CBCurrencyDataProvider cbcurrencyDataProvider = new CBCurrencyDataProvider();
        final Map<String, CBCurrency> given = cbcurrencyDataProvider.generateCbcurrencyList(3);
        final String data = cbcurrencyDataProvider.generateData(given);
        final CBCurrencyMapper cbcurrencyMapper = new CBCurrencyMapperMock(given);
        final CBCurrencyParser subject = new CBCurrencyParserImpl(cbcurrencyMapper);
        final String[] line = { "name2" };
        final CBCurrency givenCurrency = cbcurrencyMapper.mapCBCurrency(line);
        // when
        final CBCurrency returnedCurrency = subject.getCurrency(data, "name2");
        final Calendar returnedCalendar = Calendar.getInstance();
        returnedCalendar.setTime(returnedCurrency.getDate());
        final Calendar givenCalendar = Calendar.getInstance();
        givenCalendar.setTime(givenCurrency.getDate());
        // then
        Assert.assertTrue(givenCurrency.getName().equals(returnedCurrency.getName()));
        Assert.assertTrue(givenCurrency.getCode().equals(returnedCurrency.getCode()));
        Assert.assertTrue(givenCurrency.getType().equals(returnedCurrency.getType()));
        Assert.assertTrue(givenCurrency.getBuyTax().equals(returnedCurrency.getBuyTax()));
        Assert.assertTrue(givenCurrency.getSellTax().equals(returnedCurrency.getSellTax()));
        Assert.assertTrue(givenCurrency.getBuyParity().equals(returnedCurrency.getBuyParity()));
        Assert.assertTrue(givenCurrency.getSellParity().equals(returnedCurrency.getSellParity()));
        Assert.assertEquals(givenCalendar.get(Calendar.YEAR), returnedCalendar.get(Calendar.YEAR));
        Assert.assertEquals(givenCalendar.get(Calendar.MONTH), returnedCalendar.get(Calendar.MONTH));
        Assert.assertEquals(givenCalendar.get(Calendar.DAY_OF_MONTH), returnedCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test(expected = CurrencyNotAvailableException.class)
    public void shouldReturnErrorWhenCurrencyNotFound() throws IOException, ParseException {
        // given
        final CBCurrencyDataProvider cbcurrencyDataProvider = new CBCurrencyDataProvider();
        final Map<String, CBCurrency> given = cbcurrencyDataProvider.generateCbcurrencyList(3);
        final String data = cbcurrencyDataProvider.generateData(given);
        final CBCurrencyMapper cbcurrencyMapper = new CBCurrencyMapperMock(given);
        final CBCurrencyParser subject = new CBCurrencyParserImpl(cbcurrencyMapper);
        // when
        subject.getCurrency(data, "name10");
        // then (expected = CurrencyNotAvailableException.class)
    }
}
