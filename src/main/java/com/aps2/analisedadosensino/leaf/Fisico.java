package com.aps2.analisedadosensino.leaf;

import com.aps2.analisedadosensino.NomeDisciplina;

import static com.aps2.analisedadosensino.NomeDisciplina.FISICA;

public class Fisico extends Professor {

    public Fisico(Nivel nivel) {
        this.nivel = nivel;
        this.nomeDisciplina = FISICA;
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
