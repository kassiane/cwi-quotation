package com.kassiane.cwi.quotation.reader;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.kassiane.cwi.quotation.domain.Currency;

public class DateCurrencyReader {

    private final InputStream currencyCsv;

    public DateCurrencyReader(final InputStream currencyCsv) {
        this.currencyCsv = this.getClass().getResourceAsStream("/20160223.csv");
    }

    public void read() {
        final Scanner scanner = new Scanner(this.currencyCsv);
        String line = null;
        String items[] = null;

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

                final Locale ptBr = new Locale("pt", "BR");
                final DateFormat format = new SimpleDateFormat("dd/mm/yyyy", ptBr);
                Date dateD = null;
                try {
                    dateD = format.parse(date);
                } catch (final ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                final Currency currency = new Currency(name, code, type, buy_tax, sell_tax, buy_parity, sell_parity, dateD);
                System.out.println(currency.toString());
                System.out.println(format.format(currency.getDate()));
            }
        }
        scanner.close();
    }
}
