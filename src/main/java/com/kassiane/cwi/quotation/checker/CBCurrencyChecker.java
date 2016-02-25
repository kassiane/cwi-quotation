package com.kassiane.cwi.quotation.checker;

/**
 * Interface of Currency Checker.
 *
 * @author kassi
 *
 */
public interface CBCurrencyChecker {

    boolean checkMonetaryValue(float value);

    boolean checkDate(String dateToCheck);

}