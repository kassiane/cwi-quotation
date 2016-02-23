package com.kassiane.cwi.quotation.currency;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Quotation {
    public BigDecimal currencyQuotation(final String from, final String to, final Number value, final String quotation) {

        final Locale ptBr = new Locale("pt", "BR");
        final DateFormat format = new SimpleDateFormat("dd/mm/yyyy", ptBr);
        Date dateD = null;
        try {
            dateD = format.parse(quotation);
        } catch (final ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // final Currency currencyFrom = getCurrency(from);
        // final Currency currencyTo = getCurrency(to);
        return new BigDecimal(0);
    }
}
