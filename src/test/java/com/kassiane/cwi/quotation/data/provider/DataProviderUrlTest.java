package com.kassiane.cwi.quotation.data.provider;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test of class {@link DataProviderUrl}.
 *
 * @author kassi
 *
 */
public class DataProviderUrlTest {

    private static DataProviderUrl subject;

    @BeforeClass
    public static void setUp() {
        subject = new DataProviderUrl();
    }

    @Test
    public void shouldReturnURLSuccessfully() throws IOException {
        // given
        final String given = "http://www4.bcb.gov.br/Download/fechamento/20160223.csv";
        // when
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 01, 23);
        final URL returnedUrl = subject.getUrl(calendar.getTime());
        // then
        Assert.assertTrue(given.equals(returnedUrl.toString()));
    }

    @Test
    public void shouldReturnImmediatePreviousBusinessDayForSaturday() throws IOException {
        // given
        final String given = "http://www4.bcb.gov.br/Download/fechamento/20160219.csv";
        // when
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 01, 20);
        final URL returnedUrl = subject.getUrl(calendar.getTime());
        // then
        Assert.assertTrue(given.equals(returnedUrl.toString()));
    }

    @Test
    public void shouldReturnImmediatePreviousBusinessDayForSunday() throws IOException {
        // given
        final String given = "http://www4.bcb.gov.br/Download/fechamento/20160219.csv";
        // when
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 01, 21);
        final URL returnedUrl = subject.getUrl(calendar.getTime());
        // then
        Assert.assertTrue(given.equals(returnedUrl.toString()));
    }
}
