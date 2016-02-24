package com.kassiane.cwi.quotation.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CBCurrency {

    private final String name;
    private final String code;
    private final String type;
    private final BigDecimal buyTax;
    private final BigDecimal sellTax;
    private final BigDecimal buyParity;
    private final BigDecimal sellParity;
    private final Date date;

    public CBCurrency(final String name, final String code, final String type, final BigDecimal buy_tax,
            final BigDecimal sell_tax, final BigDecimal buy_parity, final BigDecimal sell_parity, final Date date) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.buyTax = buy_tax;
        this.sellTax = sell_tax;
        this.buyParity = buy_parity;
        this.sellParity = sell_parity;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }

    public BigDecimal getBuyTax() {
        return this.buyTax;
    }

    public BigDecimal getSellTax() {
        return this.sellTax;
    }

    public BigDecimal getBuyParity() {
        return this.buyParity;
    }

    public BigDecimal getSellParity() {
        return this.sellParity;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "CBCurrency [name=" + this.name + ", code=" + this.code + ", type=" + this.type + ", buyTax=" + this.buyTax
                + ", sellTax=" + this.sellTax + ", buyParity=" + this.buyParity + ", sellParity=" + this.sellParity + ", date="
                + this.date + "]";
    }

}
