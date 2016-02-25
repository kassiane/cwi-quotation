package com.kassiane.cwi.quotation.checker;

import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kassiane.cwi.quotation.mock.DateParserMock;

/**
 * Test of class {@link CBCurrencyCheckerImpl}.
 *
 * @author kassi
 *
 */
public class CBCurrencyCheckerTest {

    private static DateParser dateParser;
    private static CBCurrencyChecker subject;

    @BeforeClass
    public static void setUp() {
        dateParser = new DateParserMock(new Date());
        subject = new CBCurrencyCheckerImpl(dateParser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenNegativeValue() throws IllegalArgumentException {
        // given
        final float given = -123.0f;
        // when
        subject.checkMonetaryValue(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenZeroValue() throws IllegalArgumentException {
        // given
        final float given = 0f;
        // when
        subject.checkMonetaryValue(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test
    public void shoudlValidateValueSuccessfully() throws IllegalArgumentException {
        // given
        final float given = 156.54f;
        // when
        final boolean checked = subject.checkMonetaryValue(given);
        // then
        Assert.assertTrue(checked);
    }
}
