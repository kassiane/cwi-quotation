package com.kassiane.cwi.quotation.domain;

import java.util.Date;

public class Currency {
    private final String name;
    private final String code;
    private final String type;
    private final String buy_tax;
    private final String sell_tax;
    private final String buy_parity;
    private final String sell_parity;
    private final Date date;

    public Currency(final String name, final String code, final String type, final String buy_tax, final String sell_tax,
            final String buy_parity, final String sell_parity, final Date date) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.buy_tax = buy_tax;
        this.sell_tax = sell_tax;
        this.buy_parity = buy_parity;
        this.sell_parity = sell_parity;
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

    public String getBuy_tax() {
        return this.buy_tax;
    }

    public String getSell_tax() {
        return this.sell_tax;
    }

    public String getBuy_parity() {
        return this.buy_parity;
    }

    public String getSell_parity() {
        return this.sell_parity;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "Currency [name=" + this.name + ", code=" + this.code + ", type=" + this.type + ", buy_tax=" + this.buy_tax
                + ", sell_tax=" + this.sell_tax + ", buy_parity=" + this.buy_parity + ", sell_parity=" + this.sell_parity
                + ", date=" + this.date + "]";
    }

}
