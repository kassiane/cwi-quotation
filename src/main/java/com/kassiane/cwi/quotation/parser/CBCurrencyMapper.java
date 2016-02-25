package com.kassiane.cwi.quotation.parser;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Date;

import com.kassiane.cwi.quotation.checker.DateParser;
import com.kassiane.cwi.quotation.domain.CBCurrency;

public class CBCurrencyMapper {

    private final DateParser dateParser;

    public CBCurrencyMapper(final DateParser dateChecker) {
        this.dateParser = dateChecker;
    }

    public CBCurrency mapCBCurrency(final String currencyLine) throws ParseException {
        CBCurrency currency = null;
        final String items[] = currencyLine.split(";");
        if (items.length >= 8) {
            final String date = items[0];
            final String code = items[1];
            final String type = items[2];
            final String name = items[3];
            final String buyTax = items[4];
            final String sellTax = items[5];
            final String buyParity = items[6];
            final String sellParity = items[7];

            currency = new CBCurrency(name.toUpperCase(), code, type, this.parseMonetaryValue(buyTax),
                    this.parseMonetaryValue(sellTax), this.parseMonetaryValue(buyParity), this.parseMonetaryValue(sellParity),
                    this.parseDate(date));
        }
        return currency;
    }

    private BigDecimal parseMonetaryValue(final String value) throws ParseException {
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        final String pattern = "###,###.######";
        final DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        return (BigDecimal) decimalFormat.parse(value);
    }

    private Date parseDate(final String date) throws ParseException {
        return this.dateParser.parseDate(date);
    }

}
