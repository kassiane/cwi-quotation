package com.kassiane.cwi.quotation.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kassiane.cwi.quotation.dao.CBCurrencyDAO;
import com.kassiane.cwi.quotation.domain.CBCurrency;
import com.kassiane.cwi.quotation.exception.CurrencyNotAvailableException;
import com.kassiane.cwi.quotation.parser.CBCurrencyMapper;

public class CBCurrencyDAOImpl implements CBCurrencyDAO {

    private final CBCurrencyMapper cbcurrencyParser;

    public CBCurrencyDAOImpl(final CBCurrencyMapper cbcurrencyParser) {
        this.cbcurrencyParser = cbcurrencyParser;
    }

    @Override
    public Map<String, CBCurrency> listAll(final String data) throws IOException {
        final InputStream stream = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        final Scanner scanner = new Scanner(stream);
        final Map<String, CBCurrency> currencies = new HashMap<String, CBCurrency>();
        String line = null;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            final CBCurrency CBCurrency = this.cbcurrencyParser.mapCBCurrency(line);
            currencies.put(CBCurrency.getName(), CBCurrency);
        }
        scanner.close();
        return currencies;
    }

    @Override
    public CBCurrency getCurrency(final String data, final String name) throws IOException {
        final Map<String, CBCurrency> map = this.listAll(data);

        final CBCurrency returnCurrency = map.get(name);

        if (returnCurrency == null)
            throw new CurrencyNotAvailableException();

        return returnCurrency;
    }
}
