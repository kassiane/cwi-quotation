package com.kassiane.cwi.quotation.reader;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExternalDataSource {

    private URL input;

    public ExternalDataSource(final Date date) {
        String filename = null;
        try {
            final Locale ptBr = new Locale("pt", "BR");
            final DateFormat format = new SimpleDateFormat("yyyyMMdd", ptBr);
            filename = format.format(date);

            this.input = new URL("http://www4.bcb.gov.br/Download/fechamento/" + filename + ".csv");
        } catch (final MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public URL getExternalDataSource() {
        return this.input;
    }
}
