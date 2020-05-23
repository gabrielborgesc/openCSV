package com.aps2.analisedadosensino.leaf;

import com.aps2.analisedadosensino.NomeDisciplina;

import static com.aps2.analisedadosensino.NomeDisciplina.QUIMICA;

public class Quimico extends Professor {

    public Quimico(Nivel nivel) {
        this.nivel = nivel;
        this.nomeDisciplina = QUIMICA;
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
