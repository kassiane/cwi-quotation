package com.kassiane.cwi.quotation.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;

import com.kassiane.cwi.quotation.checker.CBCurrencyChecker;
import com.kassiane.cwi.quotation.currency.parser.CBCurrencyParser;
import com.kassiane.cwi.quotation.data.provider.DataProvider;
import com.kassiane.cwi.quotation.data.provider.DataProviderUrl;
import com.kassiane.cwi.quotation.date.parser.DateParser;
import com.kassiane.cwi.quotation.domain.CBCurrency;

public class CBCurrencyService {

    private final CBCurrencyParser cbcurrencyParser;
    private final DateParser dateParser;
    private final CBCurrencyChecker cbcurrencyChecker;
    private final DataProviderUrl dataProviderUrl;
    private final DataProvider dataProvider;

    public CBCurrencyService(final CBCurrencyParser cbcurrencyParser, final DateParser dateParser,
            final CBCurrencyChecker cbcurrencyChecker, final DataProviderUrl dataProviderUrl,
            final DataProvider dataProviderReader) {
        this.cbcurrencyParser = cbcurrencyParser;
        this.dateParser = dateParser;
        this.cbcurrencyChecker = cbcurrencyChecker;
        this.dataProviderUrl = dataProviderUrl;
        this.dataProvider = dataProviderReader;
    }

    public BigDecimal currencyQuotation(final String from, final String to, final float value, final String quotation)
            throws IOException, ParseException {
        this.cbcurrencyChecker.checkDate(quotation);
        this.cbcurrencyChecker.checkMonetaryValue(value);

        final Date date = this.dateParser.parseDate(quotation);
        final URL url = this.dataProviderUrl.getUrl(date);
        final String data = this.dataProvider.read(url);

        final CBCurrency fromCurrency = this.getCurrency(from, data);
        final CBCurrency toCurrency = this.getCurrency(to, data);
        return this.calculateCurrency(fromCurrency, toCurrency, value);
    }

    private CBCurrency getCurrency(final String currencyName, final String data) throws IOException, ParseException {
        return this.cbcurrencyParser.getCurrency(data, currencyName);
    }

    private BigDecimal calculateCurrency(final CBCurrency fromCurrency, final CBCurrency toCurrency, final float value) {
        final BigDecimal proportion = fromCurrency.getBuyTax().divide(toCurrency.getBuyTax(), 2, RoundingMode.HALF_UP);
        final BigDecimal bigDecimalValue = new BigDecimal(Float.toString(value));

        final BigDecimal currencyQuotation = proportion.multiply(bigDecimalValue);
        return currencyQuotation.abs(new MathContext(2));
    }
}
