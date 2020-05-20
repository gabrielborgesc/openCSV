package com.aps2.analisedadosensino.client;

import com.aps2.analisedadosensino.composite.Regiao;
import com.aps2.analisedadosensino.leaf.Fisico;
import com.aps2.analisedadosensino.leaf.Matematico;
import com.aps2.analisedadosensino.leaf.Outro;
import com.aps2.analisedadosensino.leaf.Quimico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Client {
	
	public static void main (String args[]) throws IOException {
		
		ReaderClient reader = new ReaderClient();
		
		Regiao regiaoNorte = new Regiao();
		List<ReaderClient> professores = reader.readCSV("Norte");
		for(ReaderClient professor : professores) {
			if(professor.getIN_DISC_MATEMATICA().equals("1")) {
				regiaoNorte.add(new Matematico());			
			}
			else if(professor.getIN_DISC_FISICA().equals("1")) {
				regiaoNorte.add(new Fisico());			
			}
			else if(professor.getIN_DISC_QUIMICA().equals("1")) {
				regiaoNorte.add(new Quimico());			
			}
			else {
				regiaoNorte.add(new Outro());	
			}
		}
		
	}
	
}
