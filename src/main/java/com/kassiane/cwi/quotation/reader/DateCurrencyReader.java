package com.kassiane.cwi.quotation.reader;

import java.io.InputStream;
import java.util.Scanner;

import com.kassiane.cwi.quotation.checker.DateChecker;
import com.kassiane.cwi.quotation.domain.Currency;

public class DateCurrencyReader {

    private final InputStream currencyCsv;

    public DateCurrencyReader() {
        this.currencyCsv = this.getClass().getResourceAsStream("/20160223.csv");
    }

    public void read(final InputStream currencyCsv) {
        final Scanner scanner = new Scanner(currencyCsv);
        String line = null;
        String items[] = null;

        final DateChecker dateChecker = new DateChecker(null);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            items = line.split(";");
            if (items.length == 8) {
                final String date = items[0];
                final String code = items[1];
                final String type = items[2];
                final String name = items[3];
                final String buy_tax = items[4];
                final String sell_tax = items[5];
                final String buy_parity = items[6];
                final String sell_parity = items[7];

                final Currency currency = new Currency(name, code, type, buy_tax, sell_tax, buy_parity, sell_parity,
                        dateChecker.check(date));
                System.out.println(currency.toString());
            }
        }
        scanner.close();
    }
}
