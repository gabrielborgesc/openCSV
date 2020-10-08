package com.aps2.analisedadosensino.client;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class SCA_Client {
	
	
	public static void main(String args[]) throws IOException, CsvValidationException {
//		Reader_SCA_CSV reader = new Reader_SCA_CSV();
//		List<Reader_SCA_CSV> requirements = reader.readCSV("C:\\Users\\User\\Documents\\Gabriel\\ReadCSV\\meuTeste.csv");
//		System.out.println(requirements.get(0).getSCA_Tag());
//		System.out.println(requirements.get(0).getRequirement_Text());
		
				List<String[]> list = new ArrayList<String[]>();
	            Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\User\\Documents\\Gabriel\\ReadCSV\\new\\newCorrectTabula.csv"));
	            CSVReader csvReader = new CSVReader(reader);
	            // Reading Records One by One in a String array
	            String[] nextRecord;
	            String[] line;
	            String[] joinLine = null;
	            while ((nextRecord = csvReader.readNext()) != null) {
	            	System.out.println("element: ");
	            	System.out.println("tamanho: " + nextRecord.length);
	            	for(int j = 0; j<nextRecord.length; j++) {
	            		System.out.println("elemento " + j + " " + nextRecord[j]);
	            	}
	            	System.out.println("\n");
	            	if(nextRecord.length==15) {
	            		line = joinBy15(nextRecord);
	            		list.add(line);
//	            		System.out.println(line);
	            	}
	            	else { //length = 6
	            		if(nextRecord[0].startsWith("S")) { //new data
	            			if(joinLine!=null) {
	            				for(int i = 0; i<joinLine.length; i++) {
	            					joinLine[i] = joinLine[i].replace("\n", " ");
	            				}
	            				list.add(joinLine);
	            			}
	            			joinLine = nextRecord;
	            		}
	            		else { // not new data, so, join
	            			for(int i = 0; i<nextRecord.length; i++) {
	            				if(!nextRecord[i].equals("")) joinLine[i] += " " + nextRecord[i];
	            			}
	            		}
	            		}
	            	}
	            if(joinLine!=null) {
    				for(int i = 0; i<joinLine.length; i++) {
    					joinLine[i] = joinLine[i].replace("\n", " ");
    				}
    				list.add(joinLine);
    			}
	            
	            
	            Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\User\\Documents\\Gabriel\\ReadCSV\\new\\final570.csv"));
	            CSVWriter csvWriter = new CSVWriter(writer);
	            
	            csvWriter.writeAll(list);
	            csvWriter.flush();
	            writer.close();
	            System.out.println(list.size());
		}

	private static String[] joinBy15(String[] nextRecord) {
		// TODO Auto-generated method stub
		String joinComma = nextRecord[0];
		for(int i=1; i<nextRecord.length; i++) {
			if(!nextRecord[i].equals("") || i==4) joinComma+="," + nextRecord[i].replace("\n", " ");
		}
		return joinComma.split(",");
	}
	
}
