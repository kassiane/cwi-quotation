package com.kassiane.cwi.quotation;

import java.io.IOException;
import java.util.Date;

import com.kassiane.cwi.quotation.dao.CBCurrencyDAO;
import com.kassiane.cwi.quotation.dao.impl.CBCurrencyDAOImpl;
import com.kassiane.cwi.quotation.exception.CurrencyNotAvailableException;
import com.kassiane.cwi.quotation.reader.DataProviderUrl;

public class Main {

    public static void main(final String[] args) {

        final DataProviderUrl dateCurrencyRemoteReader = new DataProviderUrl(new Date());
        final CBCurrencyDAO currencyReader = new CBCurrencyDAOImpl(dateCurrencyRemoteReader.getExternalDataSource());

        final String currency = "aUD";
        try {
            System.out.println(currencyReader.getCurrency(currency).toString());
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final CurrencyNotAvailableException ex) {
            System.out.println("Currency: " + currency + " not found.");
        }

    }

}
