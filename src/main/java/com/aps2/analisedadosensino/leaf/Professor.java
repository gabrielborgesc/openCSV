package com.aps2.analisedadosensino.leaf;

import com.aps2.analisedadosensino.NomeDisciplina;
import com.aps2.analisedadosensino.component.Docente;

public abstract class Professor implements Docente {

    protected NomeDisciplina nomeDisciplina;
    protected Nivel nivel;

    public abstract NomeDisciplina getNomeDisciplina();

    @Override
    public String analisa() {
        return getNomeDisciplina().toString() + getNivel().toString();
    }
}
