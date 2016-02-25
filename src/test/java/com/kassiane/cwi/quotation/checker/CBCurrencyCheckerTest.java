package com.kassiane.cwi.quotation.checker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of class {@link CBCurrencyChecker}.
 *
 * @author kassi
 *
 */
public class CBCurrencyCheckerTest {

    final CBCurrencyChecker subject;

    public CBCurrencyCheckerTest() {
        this.subject = new CBCurrencyChecker();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenMonthGreaterThanPossible() throws IllegalArgumentException {
        // given
        final String given = "12/40/2016";
        // when
        this.subject.checkDate(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenDayGreaterThanPossibleInMonth() throws IllegalArgumentException {
        // given
        final String given = "30/02/2016";
        // when
        this.subject.checkDate(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test
    public void shoudlCheckSuccessfullyValidDate() throws IllegalArgumentException {
        // given
        final String given = "20/02/2016";
        // when
        final boolean checked = this.subject.checkDate(given);
        // then
        Assert.assertTrue(checked);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenDateWithoutSlash() throws IllegalArgumentException {
        // given
        final String given = "20022016";
        // when
        this.subject.checkDate(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenNegativeValue() throws IllegalArgumentException {
        // given
        final float given = -123.0f;
        // when
        this.subject.checkMonetaryValue(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenZeroValue() throws IllegalArgumentException {
        // given
        final float given = 0f;
        // when
        this.subject.checkMonetaryValue(given);
        // then (expected = IllegalArgumentException.class)
    }
}
