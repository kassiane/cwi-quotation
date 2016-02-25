package com.kassiane.cwi.quotation.data.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import com.kassiane.cwi.quotation.exception.QuotationDateNotAvailableException;

/**
 * Entity that reads a remote quotation file and returns a String with its data.
 * Returns an error in case quotation file does not exist.
 * 
 * @author kassi
 *
 */
public class DataProvider {

    private static final String QUOTATION_NOT_AVAILABLE = "Quotation does not exist for selected date.";

    public String read(final URL url) throws IOException, QuotationDateNotAvailableException {
        Scanner scanner = null;
        final StringBuilder content = new StringBuilder();
        scanner = this.openUrlStream(url);
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return content.toString();
    }

    private Scanner openUrlStream(final URL url) throws IOException, QuotationDateNotAvailableException {
        try {
            return new Scanner(url.openStream());
        } catch (final FileNotFoundException e) {
            throw new QuotationDateNotAvailableException(QUOTATION_NOT_AVAILABLE, e);
        }
    }
}
