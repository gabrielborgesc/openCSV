package com.aps2.analisedadosensino;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadDocente {

    public static void main(String[] args) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("C:\\DadosAPSII\\Norte.csv"));

        CsvToBean<Docente> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Docente.class)
                .withSeparator('|')
                .build();

        List<Docente> initialDocentes = csvToBean.parse();
        List<Docente> docentes = new ArrayList<Docente>();
        
        for (Docente docente : initialDocentes) {
        	System.out.println(docente);
        }
        
        /*for (Docente docente : initialDocentes) {
        	docentes.add(docente.analyse());
        }
        
        for (Docente docente : docentes) {
            System.out.println(docente.getDisc());
        }*/
    }

}
