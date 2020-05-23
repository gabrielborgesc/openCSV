package com.aps2.analisedadosensino.factory;

import com.aps2.analisedadosensino.NomeDisciplina;
import com.aps2.analisedadosensino.component.Docente;
import com.aps2.analisedadosensino.leaf.*;

// Creator
public class FabricaDocente {
    public Docente criaDocente(NomeDisciplina nomeDisciplina, Nivel nivel) {

        switch (nomeDisciplina) {
            case MATEMATICA: return new Matematico(nivel);
            case FISICA: return new Fisico(nivel);
            case QUIMICA: return new Quimico(nivel);

            default: return new Outro(nivel);
        }
    }

    public void analisa(NomeDisciplina nomeDisciplina, Nivel nivel) {
        var docente = criaDocente(nomeDisciplina, nivel);
        docente.analisa();
    }
}
