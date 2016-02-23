package com.kassiane.cwi.quotation.checker;

public class CBCurrencyChecker {
    /**
     * Where:
     *
     * currency = 3 chars
     *
     * Restrictions:
     *
     * - For non-working days (Saturday and Sunday, ignoring holidays) takes the
     * quotation from the
     *
     * immediately preceding business day. If the quotation of the previous day
     * is not available, an
     *
     * exception must be thrown;
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
}
