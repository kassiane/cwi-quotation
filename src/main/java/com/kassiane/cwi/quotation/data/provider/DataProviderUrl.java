package com.kassiane.cwi.quotation.data.provider;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Entity that generates the URL which data provider reader will access. When
 * original date falls in a weekend, generated URL will be the immediately
 * preceding business day.
 *
 * @author kassi
 *
 */
public class DataProviderUrl {

    private final String baseUrl = "http://www4.bcb.gov.br/Download/fechamento/";

    public URL getUrl(final Date date) throws MalformedURLException {
        final String filename = this.formatFileName(date);

        return new URL(this.baseUrl + filename);
    }

    private String formatFileName(final Date date) {
        final Date validDate = this.checkDateForWeekends(date);
        final DateFormat format = new SimpleDateFormat("yyyyMMdd");

        return format.format(validDate) + ".csv";
    }

    private Date checkDateForWeekends(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -2);
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        return new Date(calendar.getTimeInMillis());
    }
}
