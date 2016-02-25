package com.kassiane.cwi.quotation.currency.parser;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import com.kassiane.cwi.quotation.currency.parser.impl.CBCurrencyParserImpl;
import com.kassiane.cwi.quotation.domain.CBCurrency;
import com.kassiane.cwi.quotation.mapper.CBCurrencyMapper;
import com.kassiane.cwi.quotation.mock.CBCurrencyMapperMock;

public class CBCurrencyParserTest {

    @Test
    public void shouldListAllCurrenciesCorrectly() throws IOException, ParseException {
        // given
        final Map<String, CBCurrency> given = this.generateCbcurrencyList(3);
        final String data = this.generateData(given);
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

    private Map<String, CBCurrency> generateCbcurrencyList(final int currenciesNumber) {
        final Map<String, CBCurrency> generatedList = new HashMap<String, CBCurrency>();
        for (int numberOfCurrency = currenciesNumber; numberOfCurrency > 0; numberOfCurrency--) {
            final CBCurrency generatedCurrency = this.cbccurrencyGenerator(numberOfCurrency);
            generatedList.put(generatedCurrency.getName(), generatedCurrency);
        }
        return generatedList;
    }

    private String generateData(final Map<String, CBCurrency> given) {
        String data = "";
        for (final Entry<String, CBCurrency> entry : given.entrySet()) {
            final String key = entry.getKey();
            data += key + "\n";
        }
        return data;
    }

    private CBCurrency cbccurrencyGenerator(final int currencyNumber) {
        final BigDecimal monetaryValue = new BigDecimal(currencyNumber);
        final Date date = new Date();
        return new CBCurrency("name" + currencyNumber, "123", "A", monetaryValue, monetaryValue, monetaryValue, monetaryValue,
                date);
    }

}
