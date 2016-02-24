package com.kassiane.cwi.quotation.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import com.kassiane.cwi.quotation.checker.DateChecker;
import com.kassiane.cwi.quotation.dao.CBCurrencyDAO;
import com.kassiane.cwi.quotation.dao.impl.CBCurrencyDAOImpl;
import com.kassiane.cwi.quotation.parser.CBCurrencyMapper;

public class CBCurrencyServiceTest {

    @Test
    public void shouldCalculateQuotationCorrectly() throws IOException, ParseException {
        final Locale locale = new Locale("pt", "BR");
        final DateChecker dateChecker = new DateChecker(locale);
        final CBCurrencyMapper cbcurrencyMapper = new CBCurrencyMapper(dateChecker);
        final CBCurrencyDAO cbcurrencyDAO = new CBCurrencyDAOImpl(cbcurrencyMapper);
        final CBCurrencyService cbcurrencyService = new CBCurrencyService(cbcurrencyDAO);

        final String givenFrom = "USD";
        final String givenTo = "EUR";
        final float givenValue = 100f;
        final String givenDate = "20/11/2014";

        final float thenValue = 79.69f;

        final BigDecimal calculatedValue = cbcurrencyService.currencyQuotation(givenFrom, givenTo, givenValue, givenDate);

        Assert.assertEquals(thenValue, calculatedValue.floatValue(), 2);
    }
}
