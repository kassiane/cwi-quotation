package com.kassiane.cwi.quotation.data.provider;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kassiane.cwi.quotation.exception.QuotationDateNotAvailableException;

public class DataProviderReaderTest {

    private static DataProviderUrl dataProviderUrl;
    private static DataProviderReader dataProviderReader;

    @BeforeClass
    public static void setUp() {
        dataProviderUrl = new DataProviderUrl();
        dataProviderReader = new DataProviderReader();
    }

    @Test(expected = QuotationDateNotAvailableException.class)
    public void shouldReturnErrorWhenQuotationDoesNotExist() throws IOException {
        final Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        final Date date = new Date(calendar.getTimeInMillis());

        dataProviderReader.read(dataProviderUrl.getUrl(date));

    }

    @Test
    public void shouldReturnStringWithCurrencies() throws IOException {
        final Calendar calendar = new GregorianCalendar(2016, 1, 23);
        final Date date = new Date(calendar.getTimeInMillis());
        final String data = dataProviderReader.read(dataProviderUrl.getUrl(date));

        Assert.assertTrue(data != null);
        Assert.assertTrue(data.length() > 0);
    }
}
