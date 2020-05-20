package com.aps2.analisedadosensino;

public class Docente {
	
	  private String IN_DISC_MATEMATICA;
	  private String IN_DISC_FISICA;
	  private String IN_DISC_QUIMICA;
	  private String IN_DISC_CIENCIAS;
	  private String Outra;
	  private Disc disc;
	  
	  private String IN_MESTRADO;
	  private String IN_DOUTORADO;
	  private String IN_POS_NENHUM;
	  private Nivel nivel;
	  
		
	
	public String toString() {
        return "CsvPessoa{mestrado = " + IN_MESTRADO + ", doutorado = " +
	IN_DOUTORADO + ", Nenhum = " +IN_POS_NENHUM+ "}";
    }

	public Docente analyse() {
		if(IN_DISC_MATEMATICA.equals("1")) {
			setDisc(Disc.matematica);			
		}
		else if(IN_DISC_FISICA.equals("1")) {
			setDisc(Disc.fisica);			
		}
		else if(IN_DISC_QUIMICA.equals("1")) {
			setDisc(Disc.quimica);		
		}
		else if(IN_DISC_CIENCIAS.equals("1")) {
			setDisc(Disc.ciencias);			
		}
		else {
			setDisc(Disc.outra);
		}
		
		return this;
	}
	
	public Disc getDisc() {
		return disc;
	}


	public void setDisc(Disc disc) {
		this.disc = disc;
	}


	public Nivel getNivel() {
		return nivel;
	}


	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
	public String getIN_DISC_MATEMATICA() {
		return IN_DISC_MATEMATICA;
	}


	public void setIN_DISC_MATEMATICA(String iN_DISC_MATEMATICA) {
		IN_DISC_MATEMATICA = iN_DISC_MATEMATICA;
	}


	public String getIN_DISC_CIENCIAS() {
		return IN_DISC_CIENCIAS;
	}


	public void setIN_DISC_CIENCIAS(String iN_DISC_CIENCIAS) {
		IN_DISC_CIENCIAS = iN_DISC_CIENCIAS;
	}


	public String getIN_DISC_FISICA() {
		return IN_DISC_FISICA;
	}


	public void setIN_DISC_FISICA(String iN_DISC_FISICA) {
		IN_DISC_FISICA = iN_DISC_FISICA;
	}


	public String getIN_DISC_QUIMICA() {
		return IN_DISC_QUIMICA;
	}


	public void setIN_DISC_QUIMICA(String iN_DISC_QUIMICA) {
		IN_DISC_QUIMICA = iN_DISC_QUIMICA;
	}


	public String getIN_MESTRADO() {
		return IN_MESTRADO;
	}


	public void setIN_MESTRADO(String iN_MESTRADO) {
		IN_MESTRADO = iN_MESTRADO;
	}


	public String getIN_DOUTORADO() {
		return IN_DOUTORADO;
	}


	public void setIN_DOUTORADO(String iN_DOUTORADO) {
		IN_DOUTORADO = iN_DOUTORADO;
	}


	public String getIN_POS_NENHUM() {
		return IN_POS_NENHUM;
	}


	public void setIN_POS_NENHUM(String iN_POS_NENHUM) {
		IN_POS_NENHUM = iN_POS_NENHUM;
	}


	public String getOutra() {
		return Outra;
	}


	public void setOutra(String outra) {
		Outra = outra;
	}

}
