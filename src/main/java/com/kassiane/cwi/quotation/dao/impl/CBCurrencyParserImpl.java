package com.kassiane.cwi.quotation.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kassiane.cwi.quotation.dao.CBCurrencyParser;
import com.kassiane.cwi.quotation.domain.CBCurrency;
import com.kassiane.cwi.quotation.exception.CurrencyNotAvailableException;
import com.kassiane.cwi.quotation.parser.CBCurrencyMapper;

public class CBCurrencyParserImpl implements CBCurrencyParser {

    private final CBCurrencyMapper cbcurrencyMapper;

    public CBCurrencyParserImpl(final CBCurrencyMapper cbcurrencyParser) {
        this.cbcurrencyMapper = cbcurrencyParser;
    }

    @Override
    public Map<String, CBCurrency> listAll(final String data) throws IOException, ParseException {
        final InputStream stream = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        final Scanner scanner = new Scanner(stream);
        final Map<String, CBCurrency> currencies = new HashMap<String, CBCurrency>();
        String line = null;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            final CBCurrency CBCurrency = this.cbcurrencyMapper.mapCBCurrency(line);
            currencies.put(CBCurrency.getName(), CBCurrency);
        }
        scanner.close();
        return currencies;
    }

    @Override
    public CBCurrency getCurrency(final String data, final String name) throws IOException, ParseException {
        final Map<String, CBCurrency> map = this.listAll(data);

        final CBCurrency returnCurrency = map.get(name);

        if (returnCurrency == null)
            throw new CurrencyNotAvailableException();

        return returnCurrency;
    }
}
