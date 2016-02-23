package com.kassiane.cwi.quotation;

import java.util.Date;

import com.kassiane.cwi.quotation.reader.DateCurrencyReader;
import com.kassiane.cwi.quotation.reader.DateCurrencyRemoteReader;

public class Main {

    public static void main(final String[] args) {

        final DateCurrencyReader currencyReader = new DateCurrencyReader();
        final DateCurrencyRemoteReader dateCurrencyRemoteReader = new DateCurrencyRemoteReader(new Date());

        currencyReader.read(dateCurrencyRemoteReader.getInput());

    }
}
