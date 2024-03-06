package com.srbn.utils.CSVmagnament;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class CSVManager {

        public static String readCSVFile(String filePath) throws IOException, CsvValidationException {
        StringBuilder content = new StringBuilder();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String value : nextLine) {
                    content.append(value).append("\t");
                }
                content.append("\n");
            }
        }

        return content.toString();
    }

}
