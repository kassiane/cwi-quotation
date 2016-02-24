package com.kassiane.cwi.quotation.parser;

import java.util.Date;

import com.kassiane.cwi.quotation.checker.CBCurrencyParser;
import com.kassiane.cwi.quotation.checker.DateChecker;
import com.kassiane.cwi.quotation.domain.CBCurrency;

public class CBCurrencyMapper {

    private final DateChecker dateChecker;
    private final CBCurrencyParser cbcurrencyChecker;

    public CBCurrencyMapper(final DateChecker dateChecker, final CBCurrencyParser cbcurrencyChecker) {
        this.dateChecker = dateChecker;
        this.cbcurrencyChecker = cbcurrencyChecker;
    }

    public CBCurrency mapCBCurrency(final String currencyLine) {
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

            currency = new CBCurrency(this.parseName(name), this.parseCode(code), type, buyTax, sellTax, buyParity, sellParity,
                    this.parseDate(date));
        }
        return currency;
    }

    private String parseName(final String name) {
        return this.cbcurrencyChecker.checkName(name);
    }

    private String parseCode(final String code) {
        return this.cbcurrencyChecker.checkCode(code);
    }

    private String parseType(final String type) {
        return this.cbcurrencyChecker.checkType(type);
    }

    private String parseMonetaryValues(final String value) {
        return this.cbcurrencyChecker.checkMonetaryValues(value);
    }

    private Date parseDate(final String date) {
        return this.cbcurrencyChecker.checkDate(date);
    }

}
