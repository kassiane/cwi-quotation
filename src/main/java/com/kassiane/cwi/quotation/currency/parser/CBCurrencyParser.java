package com.kassiane.cwi.quotation.currency.parser;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import com.kassiane.cwi.quotation.domain.CBCurrency;

/**
 * Interface of Currency Parser.
 * 
 * @author kassi
 *
 */
public interface CBCurrencyParser {

    Map<String, CBCurrency> listAll(String data) throws IOException, ParseException;

    CBCurrency getCurrency(String data, String name) throws IOException, ParseException;
}
