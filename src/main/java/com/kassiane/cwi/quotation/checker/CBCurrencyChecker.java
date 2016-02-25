package com.kassiane.cwi.quotation.checker;

/**
 * Interface of Currency Checker.
 *
 * @author kassi
 *
 */
public interface CBCurrencyChecker {

    boolean checkName(String nameToCheck);

    boolean checkMonetaryValue(float value);

    boolean checkDate(String dateToCheck);

}