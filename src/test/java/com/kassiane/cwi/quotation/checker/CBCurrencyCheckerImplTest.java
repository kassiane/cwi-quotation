package com.kassiane.cwi.quotation.checker;

import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kassiane.cwi.quotation.checker.impl.CBCurrencyCheckerImpl;
import com.kassiane.cwi.quotation.date.parser.DateParser;
import com.kassiane.cwi.quotation.mock.DateParserMock;

/**
 * Test of class {@link CBCurrencyCheckerImpl}.
 *
 * @author kassi
 *
 */
public class CBCurrencyCheckerImplTest {

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

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenNameIsNull() throws IllegalArgumentException {
        // given
        final String given = null;
        // when
        subject.checkName(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenNameIsEmpty() throws IllegalArgumentException {
        // given
        final String given = "";
        // when
        subject.checkName(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudlReturnErrorWhenNameHasOnlyBlankSpaces() throws IllegalArgumentException {
        // given
        final String given = "     ";
        // when
        subject.checkName(given);
        // then (expected = IllegalArgumentException.class)
    }

    @Test
    public void shoudlValidateNameSuccessfully() throws IllegalArgumentException {
        // given
        final String given = "EUR";
        // when
        final boolean checked = subject.checkName(given);
        // then
        Assert.assertTrue(checked);
    }

    @Test
    public void shoudlValidateNameWithBlankSpacesSuccessfully() throws IllegalArgumentException {
        // given
        final String given = "   AUD   ";
        // when
        final boolean checked = subject.checkName(given);
        // then
        Assert.assertTrue(checked);
    }
}
