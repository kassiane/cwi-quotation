package com.kassiane.cwi.quotation.currency.data.provider;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.kassiane.cwi.quotation.domain.CBCurrency;

/**
 * Class to give generated Currencies.
 *
 * @author kassi
 *
 */
public class CBCurrencyDataProvider {
    public Map<String, CBCurrency> generateCbcurrencyList(final int currenciesNumber) {
        final Map<String, CBCurrency> generatedList = new HashMap<String, CBCurrency>();

        for (int currencyNumber = 0; currencyNumber < currenciesNumber; currencyNumber++) {
            final CBCurrency generatedCurrency = this.generateCbcurrency(currencyNumber);
            generatedList.put(generatedCurrency.getName(), generatedCurrency);
        }
        return generatedList;
    }

    public String generateData(final Map<String, CBCurrency> given) {
        final StringBuilder data = new StringBuilder();
        for (final Entry<String, CBCurrency> entry : given.entrySet()) {
            final String key = entry.getKey();
            data.append(key).append("\n");
        }
        return data.toString();
    }

    private CBCurrency generateCbcurrency(final int currencyNumber) {
        final String name = "name" + currencyNumber;
        final String code = "code" + currencyNumber;
        final String type = "type" + currencyNumber;
        final BigDecimal buyTax = new BigDecimal(currencyNumber);
        final BigDecimal sellTax = new BigDecimal(currencyNumber + 1);
        final BigDecimal buyParity = new BigDecimal(currencyNumber + 2);
        final BigDecimal sellParity = new BigDecimal(currencyNumber + 3);
        final Date date = new Date();
        return new CBCurrency(name, code, type, buyTax, sellTax, buyParity, sellParity, date);
    }
}
