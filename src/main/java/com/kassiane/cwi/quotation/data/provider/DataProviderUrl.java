package com.kassiane.cwi.quotation.data.provider;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataProviderUrl {

    private final String baseUrl = "http://www4.bcb.gov.br/Download/fechamento/";

    public URL getUrl(final Date date) throws MalformedURLException {
        final String filename = this.formatFileName(date);

        return new URL(this.baseUrl + filename + ".csv");
    }

    private String formatFileName(final Date date) {
        final DateFormat format = new SimpleDateFormat("yyyyMMdd");

        return format.format(date);
    }
}
