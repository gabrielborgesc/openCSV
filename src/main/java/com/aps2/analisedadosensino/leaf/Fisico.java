package com.aps2.analisedadosensino.leaf;

import com.aps2.analisedadosensino.component.Docente;

public class Fisico implements Docente {

	private String pos_nenhum;
	private String mestrado;
	private String doutorado;
	private Nivel nivel;
	
	public Fisico(String pos_nenhum, String mestrado, String doutorado) {
			this.pos_nenhum = pos_nenhum;
			this.mestrado = mestrado;
			this.doutorado = doutorado;
	}
	
	@Override
	public String analyse() {
		// TODO Auto-generated method stub
		
		if(doutorado.equals("1")) {
			nivel = Nivel.doutorado;
		}
		else if(mestrado.equals("1")) {
			nivel = Nivel.mestrado;
		}
		else if(pos_nenhum.equals("1")) {
			nivel = Nivel.graduação;
		}
		else {
			nivel = Nivel.pos;
		}
		return "f"+nivel.toString(); 
	}

}
