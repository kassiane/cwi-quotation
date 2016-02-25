package com.kassiane.cwi.quotation.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kassiane.cwi.quotation.checker.CBCurrencyChecker;
import com.kassiane.cwi.quotation.checker.DateParser;
import com.kassiane.cwi.quotation.dao.CBCurrencyParser;
import com.kassiane.cwi.quotation.dao.impl.CBCurrencyParserImpl;
import com.kassiane.cwi.quotation.data.provider.DataProvider;
import com.kassiane.cwi.quotation.data.provider.DataProviderUrl;
import com.kassiane.cwi.quotation.parser.CBCurrencyMapper;

public class CBCurrencyServiceIntegrationTest {

    private static Locale locale;
    private static DateParser dateParser;
    private static CBCurrencyMapper cbcurrencyMapper;
    private static CBCurrencyParser cbcurrencyParser;
    private static CBCurrencyService cbcurrencyService;
    private static DataProviderUrl dataProviderUrl;
    private static DataProvider dataProvider;
    private static CBCurrencyChecker cbcurrencyChecker;

    @BeforeClass
    public static void setUp() {
        locale = new Locale("pt", "BR");
        dateParser = new DateParser(locale);
        cbcurrencyMapper = new CBCurrencyMapper(dateParser);
        cbcurrencyParser = new CBCurrencyParserImpl(cbcurrencyMapper);
        dataProviderUrl = new DataProviderUrl();
        dataProvider = new DataProvider();
        cbcurrencyChecker = new CBCurrencyChecker();
        cbcurrencyService = new CBCurrencyService(cbcurrencyParser, dateParser, cbcurrencyChecker, dataProviderUrl, dataProvider);
    }

    @Test
    public void shouldCalculateQuotationCorrectly() throws IOException, ParseException {
        final String givenFrom = "USD";
        final String givenTo = "EUR";
        final float givenValue = 100f;
        final String givenDate = "20/11/2014";

        final float thenValue = 79.69f;

        final BigDecimal calculatedValue = cbcurrencyService.currencyQuotation(givenFrom, givenTo, givenValue, givenDate);

        Assert.assertEquals(thenValue, calculatedValue.floatValue(), 2);
    }
}