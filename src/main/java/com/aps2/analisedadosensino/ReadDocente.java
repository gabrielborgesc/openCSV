package com.aps2.analisedadosensino;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadDocente {

    public static void main(String[] args) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Ronaldo\\Desktop\\Matérias\\4.1\\APSII\\TrabalhoVE\\microdados_educacao_basica_2019\\DADOS\\TESTEDOCENTE.csv"));

        CsvToBean<Docente> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Docente.class)
                .withSeparator('|')
                .build();

        List<Docente> docentes = csvToBean.parse();

        for (Docente docente : docentes)
            System.out.println(docente);

    }

}
