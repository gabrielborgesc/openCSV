package com.aps2.analisedadosensino.composite;

import com.aps2.analisedadosensino.Disciplina;
import com.aps2.analisedadosensino.component.Docente;

import java.util.ArrayList;
import java.util.List;

public class Regiao implements Docente {
	
	private String nome;
	private List<Docente> docentes = new ArrayList<Docente>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	@Override
	public String analyse() {
		// TODO Auto-generated method stub
		String[] nomesdisc = {"matematica, fisica, quimica, outra"};
		String s="";
				
		for(String nome : nomesdisc) {
			disciplinas.add(new Disciplina(nome));
		}
		
		String aux;
		
		for(Docente docente : docentes) {
			aux = docente.analyse();
			
			if(aux.startsWith("m")) {
				disciplinas.set(0, disciplinas.get(0).add(aux.substring(1)));
			}
			else if(aux.startsWith("f")) {
				disciplinas.set(1, disciplinas.get(1).add(aux.substring(1)));
			}
			else if(aux.startsWith("q")) {
				disciplinas.set(2, disciplinas.get(2).add(aux.substring(1)));
			}
			else {
				disciplinas.set(3, disciplinas.get(3).add(aux.substring(1)));
			}
		}
		
		s+="Região "+ nome+":\n";
		for(int i = 0;i<4;i++) {
		s+=disciplinas.get(i).getNome()+ ":\n";
		s+="Quantidade total de docentes: "+disciplinas.get(i).getQtotal()+"\n";
		s+="Docentes com apenas graduação: "+disciplinas.get(i).getQgraduacao()+"\n";
		s+="Docentes com apenas pós graduação: "+disciplinas.get(i).getQpos()+"\n";
		s+="Docentes mestres: "+disciplinas.get(i).getQmestrado()+"\n";
		s+="Docentes doutores: "+disciplinas.get(i).getQdoutorado()+"\n\n";
		
	}
		return s;
}	

	public void add(Docente docente) {
		docentes.add(docente);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
