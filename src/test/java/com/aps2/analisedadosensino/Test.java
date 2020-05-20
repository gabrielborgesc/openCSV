package com.aps2.analisedadosensino;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;



public class Test {

	public Integer x;
	public Test2 t2 = new Test2();
	
	public static void main (String args[]) throws IOException {
		
		 Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Ronaldo\\Desktop\\Matérias\\4.1\\APSII\\TrabalhoVE\\microdados_educacao_basica_2019\\DADOS\\TESTEDOCENTE.csv"));

	        CsvToBean<Docente> csvToBean = new CsvToBeanBuilder(reader)
	                .withType(Docente.class)
	                .withSeparator('|')
	                .build();

	        List<Docente> initialDocentes = csvToBean.parse();
	        List<Docente> docentes = new ArrayList<Docente>();
	        
		/*
		 * for (Docente docente : initialDocentes) { docentes.add(docente.analyse()); }
		 */
	        
		/*
		 * for (Docente docente : docentes) { System.out.println(docente.getDisc()); }
		 */
	        
	        for(Docente docente : initialDocentes) {
	        	System.out.println(docente);
	        }
}
}
