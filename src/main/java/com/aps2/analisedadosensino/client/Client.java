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
		List<ReaderClient> professores = new ArrayList<ReaderClient>();
		Regiao regiao = new Regiao();
		String[] nomesRegioes = {"Norte", "Nordeste", "Centro-Oeste", "Sudeste", "Sul"}; 
		String analyse = "";
		String percent = "\n\n";
		
		for(String nome : nomesRegioes) {///pega as informações das tabelas CSV	
			regiao.setNome(nome);
			professores = reader.readCSV(nome);
			
			for(ReaderClient professor : professores) {
				if(professor.getIN_DISC_MATEMATICA().equals("1")) {
					regiao.add(new Matematico(professor.getIN_POS_NENHUM(), professor.getIN_MESTRADO(), professor.getIN_DOUTORADO()));			
				}
				else if(professor.getIN_DISC_FISICA().equals("1")) {
					regiao.add(new Fisico(professor.getIN_POS_NENHUM(), professor.getIN_MESTRADO(), professor.getIN_DOUTORADO()));			
				}
				else if(professor.getIN_DISC_QUIMICA().equals("1")) {
					regiao.add(new Quimico(professor.getIN_POS_NENHUM(), professor.getIN_MESTRADO(), professor.getIN_DOUTORADO()));			
				}
				else {
					regiao.add(new Outro(professor.getIN_POS_NENHUM(), professor.getIN_MESTRADO(), professor.getIN_DOUTORADO()));	
				}
			}
			
			analyse += regiao.analyse();
			percent+= regiao.percent();
			regiao.reset();
		}
		
		System.out.println(analyse+percent);
		
	}
	
}
