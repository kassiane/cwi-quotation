package com.kassiane.cwi.quotation.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import com.kassiane.cwi.quotation.checker.CBCurrencyChecker;
import com.kassiane.cwi.quotation.checker.DateChecker;
import com.kassiane.cwi.quotation.dao.CBCurrencyDAO;
import com.kassiane.cwi.quotation.data.provider.DataProviderReader;
import com.kassiane.cwi.quotation.data.provider.DataProviderUrl;
import com.kassiane.cwi.quotation.domain.CBCurrency;

public class CBCurrencyService {

    private final CBCurrencyDAO currencyDAO;

    public CBCurrencyService(final CBCurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    public BigDecimal currencyQuotation(final String from, final String to, final float value, final String quotation)
            throws IOException, ParseException {
        final Locale ptBr = new Locale("pt", "BR");
        final DateChecker dateChecker = new DateChecker(ptBr);
        final CBCurrencyChecker cbcurrencyChecker = new CBCurrencyChecker(dateChecker);
        final DataProviderUrl dataProviderUrl = new DataProviderUrl();
        final DataProviderReader dataProviderReader = new DataProviderReader();
        // validate entries here
        cbcurrencyChecker.checkDate(quotation);
        cbcurrencyChecker.checkMonetaryValue(value);

        final Date date = dateChecker.parseDate(quotation);
        final URL url = dataProviderUrl.getUrl(date);

        final String data = dataProviderReader.read(url);
        final CBCurrency fromCurrency = this.currencyDAO.getCurrency(from, data);
        final CBCurrency toCurrency = this.currencyDAO.getCurrency(to, data);

        final BigDecimal proportion = fromCurrency.getBuyTax().divide(toCurrency.getBuyTax());

        final BigDecimal bigDecimalValue = new BigDecimal(Float.toString(value));

        return proportion.multiply(bigDecimalValue, new MathContext(2));
    }
}
