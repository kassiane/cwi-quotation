package com.kassiane.cwi.quotation.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import com.kassiane.cwi.quotation.domain.CBCurrency;

public interface CBCurrencyParser {

    Map<String, CBCurrency> listAll(String data) throws IOException, ParseException;

    CBCurrency getCurrency(String data, String name) throws IOException, ParseException;
}
