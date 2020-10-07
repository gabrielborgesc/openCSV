package com.aps2.analisedadosensino.client;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class Test {
	
	public static void main(String args[]) throws IOException {
		
		String s = "SCA11,The disconnectPorts operation shall release all ports if the input portDisconnections parameter is a zero length sequence.,3.1.3.2.1.2.5.2.3,BaseComponent,Connectable,Manual";
		String[] s2 = s.split(",");
		String s4 = "SCA10,The disconnectPorts operation shall break the connection(s) to the component identified by the input portDisconnections parameter.,3.1.3.2.1.2.5.2.3,BaseComponent,Connectable,Manual";
		String[] s5 = s4.split(",");
		List<String[]> matrix = new ArrayList<String[]>();
		matrix.add(s2);
		matrix.add(s5);
		
		for(String[] array : matrix) {
			for(String aux : array) {
				//System.out.println(aux);
			}
			//System.out.println("\n");
		}
 		
	//	String[] cabecalho = {"nome", "idade", "telefone"};

        Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\User\\Documents\\Gabriel\\ReadCSV\\Writer.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

      //  csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(matrix);

        csvWriter.flush();
        writer.close();
}
}
