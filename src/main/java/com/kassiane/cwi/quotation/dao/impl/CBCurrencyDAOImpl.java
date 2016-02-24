package com.kassiane.cwi.quotation.dao.impl;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kassiane.cwi.quotation.checker.DateChecker;
import com.kassiane.cwi.quotation.dao.CBCurrencyDAO;
import com.kassiane.cwi.quotation.domain.CBCurrency;
import com.kassiane.cwi.quotation.exception.CurrencyNotAvailableException;

public class CBCurrencyDAOImpl implements CBCurrencyDAO {

    private final URL currencyCsv;

    public CBCurrencyDAOImpl(final URL currencyCsv) {
        this.currencyCsv = currencyCsv;
    }

    @Override
    public Map<String, CBCurrency> listAll() throws IOException {
        final Scanner scanner = new Scanner(this.currencyCsv.openStream());
        String line = null;
        String items[] = null;

        final Map<String, CBCurrency> map = new HashMap<String, CBCurrency>();

        final DateChecker dateChecker = new DateChecker(null);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            items = line.split(";");
            if (items.length == 8) {
                final String date = items[0];
                final String code = items[1];
                final String type = items[2];
                final String name = items[3];
                final String buy_tax = items[4];
                final String sell_tax = items[5];
                final String buy_parity = items[6];
                final String sell_parity = items[7];

                final CBCurrency currency = new CBCurrency(name, code, type, buy_tax, sell_tax, buy_parity, sell_parity,
                        dateChecker.check(date));
                map.put(name, currency);
                System.out.println(currency.toString());
            }
        }
        scanner.close();
        return map;
    }

    @Override
    public CBCurrency getCurrency(final String name) throws IOException {
        final Map<String, CBCurrency> map = this.listAll();

        final CBCurrency returnCurrency = map.get(name);

        if (returnCurrency == null)
            throw new CurrencyNotAvailableException();

        return returnCurrency;
    }
}
