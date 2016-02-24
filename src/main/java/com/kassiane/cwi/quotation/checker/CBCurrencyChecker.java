package com.kassiane.cwi.quotation.checker;

import java.util.Calendar;
import java.util.Date;

public class CBCurrencyChecker {

    private final String negativeValue = "Value must not be negative or zero.";

    private final DateChecker dateChecker;

    public CBCurrencyChecker(final DateChecker dateChecker) {
        this.dateChecker = dateChecker;
    }

    public String checkName(final String currencyName) {
        return currencyName.toUpperCase();
    }

    /**
     * Where:
     *
     * currency = 3 chars
     *
     * Restrictions:
     *
     *
     *
     * - If the quotation date is not available, an exception must be thrown;
     *
     * - The data source used will be the Brazilian central bank CSV file
     * available at:
     *
     * http://www4.bcb.gov.br/pec/taxas/batch/cotacaomoedas.asp?id=txtodas
     *
     * - The return value should be rounded to two decimal places.
     *
     * - You must convert the currency through rate "Taxa Compra".
     */

    public void checkMonetaryValue(final float value) {
        if (value <= 0) {
            throw new IllegalArgumentException(this.negativeValue);
        }
    }

    /**
     * For non-working days (Saturday and Sunday, ignoring holidays) takes the
     * quotation from the immediately preceding business day. If the quotation
     * of the previous day is not available, an exception must be thrown;
     *
     * @param dateToCheck
     * @return date when it is weekday, new valid date otherwise
     */
    public String checkDate(final String dateToCheck) {
        final Date date = this.dateChecker.parseDate(dateToCheck);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -2);
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        return this.dateChecker.getFormattedDate(new Date(calendar.getTimeInMillis()));
    }
}
