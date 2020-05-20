package com.aps2.analisedadosensino;

public class Disciplina {

	private String nome;
	private Integer qtotal;
	private Integer qgraduacao;
	private Integer qpos;
	private Integer qmestrado;
	private Integer qdoutorado;
	private Integer qseminfo;
	private Float posgradmat;
	
	public Disciplina(String nome) {
			this.nome = nome;
			this.qtotal = 0;
			this.qgraduacao = 0;
			this.qpos = 0;
			this.qmestrado = 0;
			this.qdoutorado = 0;
			this.qseminfo = 0;
	}
	
	public Disciplina add(String info) {
		qtotal++;
		if(info.equals("doutorado")) {
			qdoutorado++;
		}
		else if(info.equals("mestrado")) {
			qmestrado++;
		}
		else if(info.equals("pos")) {
			qpos++;
		}
		else if(info.equals("graduação")) {
			qgraduacao++;
		}
		else {
			qseminfo++;
		}
		return this;
}
	
	public Disciplina calculate() {
		posgradmat = (float) 100*(qpos + qmestrado + qdoutorado)/qtotal;
		return this;
	}
	
	public Integer getQtotal() {
		return qtotal;
	}
	public void setQtotal(Integer qtotal) {
		this.qtotal = qtotal;
	}
	public Integer getQgraduacao() {
		return qgraduacao;
	}
	public void setQgraduacao(Integer qgraduacao) {
		this.qgraduacao = qgraduacao;
	}
	public Integer getQpos() {
		return qpos;
	}
	public void setQpos(Integer qpos) {
		this.qpos = qpos;
	}
	public Integer getQmestrado() {
		return qmestrado;
	}
	public void setQmestrado(Integer qmestrado) {
		this.qmestrado = qmestrado;
	}
	public Integer getQdoutorado() {
		return qdoutorado;
	}
	public void setQdoutorado(Integer qdoutorado) {
		this.qdoutorado = qdoutorado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQseminfo() {
		return qseminfo;
	}

	public void setQseminfo(Integer qseminfo) {
		this.qseminfo = qseminfo;
	}

	public Float getPosgradmat() {
		return posgradmat;
	}

	public void setPosgradmat(Float posgradmat) {
		this.posgradmat = posgradmat;
	}
	
	
}
