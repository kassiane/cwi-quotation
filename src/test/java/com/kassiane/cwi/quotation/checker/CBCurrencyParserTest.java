package com.kassiane.cwi.quotation.checker;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class CBCurrencyParserTest {

    final CBCurrencyChecker cbCurrencyParser;
    final DateChecker dateChecker;

    public CBCurrencyParserTest() {
        this.dateChecker = new DateChecker(new Locale("pt", "BR"));
        this.cbCurrencyParser = new CBCurrencyChecker(this.dateChecker);
    }

    @Test
    public void shouldReturnPreviousWeekdayGivenSaturday() {
        final String given = "20/02/2016";
        final String then = "19/02/2016";
        final String givenChecked = this.cbCurrencyParser.checkDate(given);

        Assert.assertTrue(givenChecked.equals(then));

    }

    @Test
    public void shouldReturnPreviousWeekdayGivenSunday() {
        final String given = "21/02/2016";
        final String then = "19/02/2016";
        final String givenChecked = this.cbCurrencyParser.checkDate(given);

        Assert.assertTrue(givenChecked.equals(then));

    }
}
