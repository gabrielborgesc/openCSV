package com.aps2.analisedadosensino.composite;

import java.util.ArrayList;
import java.util.List;

import com.aps2.analisedadosensino.component.Docente;

public class Regiao implements Docente {
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void analyse() {
		// TODO Auto-generated method stub
		
	}
	
	public void add(Docente docente) {
		docentes.add(docente);
	}

}
