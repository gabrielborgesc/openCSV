package com.aps2.analisedadosensino.client;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class SCA_Client {

	public static void main(String args[]) throws IOException, CsvValidationException {
//		Reader_SCA_CSV reader = new Reader_SCA_CSV();
//		List<Reader_SCA_CSV> requirements = reader.readCSV("C:\\Users\\User\\Documents\\Gabriel\\ReadCSV\\meuTeste.csv");
//		System.out.println(requirements.get(0).getSCA_Tag());
//		System.out.println(requirements.get(0).getRequirement_Text());
		
		
	            Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\User\\Documents\\Gabriel\\ReadCSV\\Sample.csv"));
	            CSVReader csvReader = new CSVReader(reader);
	            // Reading Records One by One in a String array
	            String[] nextRecord;
	            String join = "";
	            while ((nextRecord = csvReader.readNext()) != null) {
	            	System.out.println("element: ");
	            	System.out.println("tamanho: " + nextRecord.length);
	            	for(int j = 0; j<nextRecord.length; j++) {
	            		System.out.println("elemento " + j + " " + nextRecord[j]);
	            	}
	            	System.out.println("\n");
	            	if(nextRecord.length==15) {
	            		join = splitBy15(nextRecord);
	            		System.out.println(join);
	            	}
	            	else {
	            		
	            	}
	            }
		}

	private static String splitBy15(String[] nextRecord) {
		// TODO Auto-generated method stub
		String joinComma = nextRecord[0];
		for(int i=1; i<nextRecord.length; i++) {
			if(!nextRecord[i].equals("") || i==4) joinComma+="," + nextRecord[i].replace("\n", " ");
		}
		return joinComma;
	}
	
}
