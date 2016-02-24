package com.kassiane.cwi.quotation.dao;

import java.io.IOException;
import java.util.Map;

import com.kassiane.cwi.quotation.domain.CBCurrency;

public interface CBCurrencyDAO {

    Map<String, CBCurrency> listAll(String data) throws IOException;

    CBCurrency getCurrency(String data, String name) throws IOException;
}
