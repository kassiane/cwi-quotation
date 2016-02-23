package com.kassiane.cwi.quotation.dao;

import java.io.IOException;
import java.util.Map;

import com.kassiane.cwi.quotation.domain.CBCurrency;

public interface CurrencyDAO {

    public Map<String, CBCurrency> listAll() throws IOException;

    public CBCurrency getCurrency(String name) throws IOException;
}
