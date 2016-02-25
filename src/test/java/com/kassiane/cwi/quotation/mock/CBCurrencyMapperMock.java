package com.kassiane.cwi.quotation.mock;

import java.text.ParseException;

import com.kassiane.cwi.quotation.domain.CBCurrency;
import com.kassiane.cwi.quotation.mapper.CBCurrencyMapper;

public class CBCurrencyMapperMock implements CBCurrencyMapper {

    private final CBCurrency cbcurrency;

    public CBCurrencyMapperMock(final CBCurrency cbcurrency) {
        this.cbcurrency = cbcurrency;
    }

    @Override
    public CBCurrency mapCBCurrency(final String[] items) throws ParseException, IllegalArgumentException {
        return this.cbcurrency;
    }

}
