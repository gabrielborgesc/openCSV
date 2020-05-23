package com.aps2.analisedadosensino.leaf;

import com.aps2.analisedadosensino.NomeDisciplina;

import static com.aps2.analisedadosensino.NomeDisciplina.OUTRAS;

public class Outro extends Professor {

    public Outro(Nivel nivel) {
        this.nivel = nivel;
        this.nomeDisciplina = OUTRAS;
    }

    @Override
    public Nivel getNivel() {
        return this.nivel;
    }

    @Override
    public NomeDisciplina getNomeDisciplina() {
        return this.nomeDisciplina;
    }
}
