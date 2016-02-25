package com.kassiane.cwi.quotation.checker;

public interface CBCurrencyChecker {

    boolean checkMonetaryValue(float value);

    boolean checkDate(String dateToCheck);

}