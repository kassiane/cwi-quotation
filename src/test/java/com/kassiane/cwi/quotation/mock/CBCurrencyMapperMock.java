package com.kassiane.cwi.quotation.mock;

import java.text.ParseException;
import java.util.Map;

import com.kassiane.cwi.quotation.domain.CBCurrency;
import com.kassiane.cwi.quotation.mapper.CBCurrencyMapper;

/**
 * Class to mock {@link CBCurrencyMapper}.
 *
 * @author kassi
 *
 */
public class CBCurrencyMapperMock implements CBCurrencyMapper {

    private final Map<String, CBCurrency> cbcurrency;

    public CBCurrencyMapperMock(final Map<String, CBCurrency> cbcurrency) {
        this.cbcurrency = cbcurrency;
    }

    @Override
    public CBCurrency mapCBCurrency(final String[] items) throws ParseException, IllegalArgumentException {
        return this.cbcurrency.get(items[0]);
    }

}
