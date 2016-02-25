package com.kassiane.cwi.quotation.mapper;

import java.text.ParseException;

import com.kassiane.cwi.quotation.domain.CBCurrency;

/**
 * Interface of Currency Mapper.
 *
 * @author kassi
 *
 */
public interface CBCurrencyMapper {

    CBCurrency mapCBCurrency(String[] items) throws ParseException, IllegalArgumentException;

}