package com.aps2.analisedadosensino.leaf;

import com.aps2.analisedadosensino.NomeDisciplina;

import static com.aps2.analisedadosensino.NomeDisciplina.MATEMATICA;

public class Matematico extends Professor {

    public Matematico(Nivel nivel) {
        this.nivel = nivel;
        this.nomeDisciplina = MATEMATICA;
    }

    @Override
    public Nivel getNivel() {
        return this.nivel;
    }

    @Override
    public NomeDisciplina getNomeDisciplina () {
        return this.nomeDisciplina;
    }
}
