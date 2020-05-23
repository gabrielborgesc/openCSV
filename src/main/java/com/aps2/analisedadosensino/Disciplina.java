package com.aps2.analisedadosensino;

import com.aps2.analisedadosensino.component.Docente;
import com.aps2.analisedadosensino.leaf.Nivel;

import java.util.ArrayList;
import java.util.List;

import static com.aps2.analisedadosensino.Utils.BREAK_LINE;

public class Disciplina implements Docente {

    private NomeDisciplina nome;
    private List<Docente> docentes;
    private int total;
    private int graduados;
    private int posGraduados;
    private int mestres;
    private int doutores;
    private int semInformacao;
    private double porcentagemComAlgumaPosGraduacao;

    public Disciplina(NomeDisciplina nome) {
        this.nome = nome;
        this.docentes = new ArrayList<Docente>();
        this.total = 0;
        this.graduados = 0;
        this.posGraduados = 0;
        this.mestres = 0;
        this.doutores = 0;
        this.semInformacao = 0;
        this.porcentagemComAlgumaPosGraduacao = 0.0;
    }

    public void adiciona(Docente docente) {
        this.docentes.add(docente);
    }

    @Override
    public Nivel getNivel() {
        return null;
    }

    @Override
    public NomeDisciplina getNomeDisciplina() {
        return null;
    }

    public String analisa() {
        this.calculaNivel();

        return this.nome.toString() + ":" + BREAK_LINE +
                "Total de docentes: " + this.total + BREAK_LINE +
                "Docentes com apenas graduação: " + this.graduados + BREAK_LINE +
                "Docentes com apenas pós-graduação: " + this.posGraduados + BREAK_LINE +
                "Docentes com mestrado: " + this.mestres + BREAK_LINE +
                "Docentes com doutorado: " + this.doutores + BREAK_LINE +
                "Sem informação: " + this.semInformacao + BREAK_LINE;
    }

    private void calculaNivel() {
        this.docentes.forEach(this::calculaNivel);
        this.porcentagemComAlgumaPosGraduacao = 100 * (posGraduados + mestres + doutores) / (double) total;
    }

    private void calculaNivel(Docente docente) {
        this.total++;

        switch (docente.getNivel()) {
            case GRADUAÇÃO:
                this.graduados++;
                break;
            case POS_GRADUAÇÃO:
                this.posGraduados++;
                break;
            case MESTRADO:
                this.mestres++;
                break;
            case DOUTORADO:
                this.doutores++;
                break;
            default:
                this.semInformacao++;
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getGraduados() {
        return graduados;
    }

    public void setGraduados(Integer graduados) {
        this.graduados = graduados;
    }

    public Integer getPosGraduados() {
        return posGraduados;
    }

    public void setPosGraduados(Integer posGraduados) {
        this.posGraduados = posGraduados;
    }

    public Integer getMestres() {
        return mestres;
    }

    public void setMestres(Integer mestres) {
        this.mestres = mestres;
    }

    public Integer getDoutores() {
        return doutores;
    }

    public void setDoutores(Integer doutores) {
        this.doutores = doutores;
    }

    public NomeDisciplina getNome() {
        return nome;
    }

    public void setNome(NomeDisciplina nome) {
        this.nome = nome;
    }

    public Integer getSemInformacao() {
        return semInformacao;
    }

    public void setSemInformacao(Integer semInformacao) {
        this.semInformacao = semInformacao;
    }

    public Double getPorcentagemComAlgumaPosGraduacao() {
        return porcentagemComAlgumaPosGraduacao;
    }

    public void setPorcentagemComAlgumaPosGraduacao(Float porcentagemComAlgumaPosGraduacao) {
        this.porcentagemComAlgumaPosGraduacao = porcentagemComAlgumaPosGraduacao;
    }

}
