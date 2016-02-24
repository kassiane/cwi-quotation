package com.kassiane.cwi.quotation.data.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import com.kassiane.cwi.quotation.exception.QuotationDateNotAvailableException;

public class DataProviderReader {

    private final String quotationNotAvailable = "Não existe cotação para a data selecionada.";

    public String read(final URL url) throws IOException, QuotationDateNotAvailableException {
        Scanner scanner = null;
        String content = null;
        scanner = this.openUrlStream(url);

        while (scanner.hasNextLine()) {
            content += scanner.nextLine() + "\n";
        }
        scanner.close();
        return content;
    }

    private Scanner openUrlStream(final URL url) throws IOException, QuotationDateNotAvailableException {
        try {
            return new Scanner(url.openStream());
        } catch (final FileNotFoundException e) {
            throw new QuotationDateNotAvailableException(this.quotationNotAvailable, e);
        }
    }
}
