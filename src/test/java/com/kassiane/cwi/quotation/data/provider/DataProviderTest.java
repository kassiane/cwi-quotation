package com.kassiane.cwi.quotation.data.provider;

import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kassiane.cwi.quotation.exception.QuotationDateNotAvailableException;

/**
 * Test of class {@link DatProvider}.
 *
 * @author kassi
 *
 */
public class DataProviderTest {

    private static DataProvider subject;

    @BeforeClass
    public static void setUp() {
        subject = new DataProvider();
    }

    @Test(expected = QuotationDateNotAvailableException.class)
    public void shouldReturnErrorWhenQuotationDoesNotExist() throws IOException {
        // given
        final URL given = new URL("http://www4.bcb.gov.br/Download/fechamento/20160101.csv");
        // when
        subject.read(given);
        // then (expected = QuotationDateNotAvailableException.class)
    }

    @Test
    public void shouldReturnStringWithCurrencies() throws IOException {
        // given
        final URL given = new URL("http://www4.bcb.gov.br/Download/fechamento/20160223.csv");
        // when
        final String data = subject.read(given);
        // then
        Assert.assertTrue(data != null);
        Assert.assertTrue(data.length() > 0);
    }
}
