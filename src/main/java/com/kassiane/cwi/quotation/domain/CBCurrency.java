package com.kassiane.cwi.quotation.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity with Central Bank currency information.
 *
 * @author kassi
 *
 */
public class CBCurrency {

    private final String name;
    private final String code;
    private final String type;
    private final BigDecimal buyTax;
    private final BigDecimal sellTax;
    private final BigDecimal buyParity;
    private final BigDecimal sellParity;
    private final Date date;

    public CBCurrency(final String name, final String code, final String type, final BigDecimal buyTax, final BigDecimal sellTax,
            final BigDecimal buyParity, final BigDecimal sellParity, final Date date) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.buyTax = buyTax;
        this.sellTax = sellTax;
        this.buyParity = buyParity;
        this.sellParity = sellParity;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.buyParity == null) ? 0 : this.buyParity.hashCode());
        result = prime * result + ((this.buyTax == null) ? 0 : this.buyTax.hashCode());
        result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
        result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.sellParity == null) ? 0 : this.sellParity.hashCode());
        result = prime * result + ((this.sellTax == null) ? 0 : this.sellTax.hashCode());
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof CBCurrency))
            return false;
        final CBCurrency other = (CBCurrency) obj;
        if (this.buyParity == null) {
            if (other.buyParity != null)
                return false;
        } else if (!this.buyParity.equals(other.buyParity))
            return false;
        if (this.buyTax == null) {
            if (other.buyTax != null)
                return false;
        } else if (!this.buyTax.equals(other.buyTax))
            return false;
        if (this.code == null) {
            if (other.code != null)
                return false;
        } else if (!this.code.equals(other.code))
            return false;
        if (this.date == null) {
            if (other.date != null)
                return false;
        } else if (!this.date.equals(other.date))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (!this.name.equals(other.name))
            return false;
        if (this.sellParity == null) {
            if (other.sellParity != null)
                return false;
        } else if (!this.sellParity.equals(other.sellParity))
            return false;
        if (this.sellTax == null) {
            if (other.sellTax != null)
                return false;
        } else if (!this.sellTax.equals(other.sellTax))
            return false;
        if (this.type == null) {
            if (other.type != null)
                return false;
        } else if (!this.type.equals(other.type))
            return false;
        return true;
    }

}
