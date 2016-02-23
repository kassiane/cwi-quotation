package com.kassiane.cwi.quotation;

import com.kassiane.cwi.quotation.reader.DateCurrencyReader;

public class Main {

    public static void main(final String[] args) {

        final DateCurrencyReader currencyReader = new DateCurrencyReader(null);
        currencyReader.read();

    }
}
