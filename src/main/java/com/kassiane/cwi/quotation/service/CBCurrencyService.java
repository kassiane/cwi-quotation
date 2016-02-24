package com.kassiane.cwi.quotation.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.kassiane.cwi.quotation.dao.CBCurrencyDAO;
import com.kassiane.cwi.quotation.domain.CBCurrency;

public class CBCurrencyService {

    private final CBCurrencyDAO currencyDAO;

    public CBCurrencyService(final CBCurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    public BigDecimal currencyQuotation(final String from, final String to, final Number value, final String quotation)
            throws IOException {

        // validate entries here

        // get currencies from datasource
        final CBCurrency fromCurrency = this.currencyDAO.getCurrency(from);
        final CBCurrency toCurrency = this.currencyDAO.getCurrency(to);

        final Locale ptBr = new Locale("pt", "BR");
        final DateFormat format = new SimpleDateFormat("dd/mm/yyyy", ptBr);
        Date dateD = null;
        try {
            dateD = format.parse(quotation);
        } catch (final ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new BigDecimal(0);
    }
}
