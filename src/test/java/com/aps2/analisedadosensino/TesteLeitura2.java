package com.aps2.analisedadosensino;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TesteLeitura2 {

    public static void main(String[] args) throws IOException, CsvException {

        Reader reader = Files.newBufferedReader(Paths.get("C:/Pessoas.csv"));
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(
        		new CSVParserBuilder()
        		.withSeparator('|')
        		.build()
        		)
        		.withSkipLines(1)
        		.build();

        List<String[]> pessoas = csvReader.readAll();
        for (String[] pessoa : pessoas)
            System.out.println("Name : " + pessoa[0] +
                            " - Idade : " + pessoa[1] +
                            " - Email : " + pessoa[2]);

    }

}