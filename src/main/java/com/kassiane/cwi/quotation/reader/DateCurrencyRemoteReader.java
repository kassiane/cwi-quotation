package com.kassiane.cwi.quotation.reader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateCurrencyRemoteReader {

    InputStream input;

    public DateCurrencyRemoteReader(final Date date) {
        String filename = null;
        try {
            final Locale ptBr = new Locale("pt", "BR");
            final DateFormat format = new SimpleDateFormat("yyyyMMdd", ptBr);
            filename = format.format(date);

            this.input = new URL("http://www4.bcb.gov.br/Download/fechamento/" + filename + ".csv").openStream();
        } catch (final MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public InputStream getInput() {
        return this.input;
    }
}
