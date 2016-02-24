package com.kassiane.cwi.quotation.data.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class DataProviderReader {

    public String read(final URL url) throws IOException, FileNotFoundException {
        final Scanner scanner = new Scanner(url.openStream());
        String content = null;

        while (scanner.hasNextLine()) {
            content += scanner.nextLine() + "\n";
        }
        scanner.close();
        return content;
    }
}
