package com.aps2.analisedadosensino.factory;

import static com.aps2.analisedadosensino.NomeDisciplina.FISICA;
import static com.aps2.analisedadosensino.NomeDisciplina.MATEMATICA;
import static com.aps2.analisedadosensino.NomeDisciplina.OUTRAS;
import static com.aps2.analisedadosensino.NomeDisciplina.QUIMICA;
import static com.aps2.analisedadosensino.Utils.parseBoolean;

import com.aps2.analisedadosensino.NomeDisciplina;
import com.aps2.analisedadosensino.client.ReaderClient;
import com.aps2.analisedadosensino.component.Docente;
import com.aps2.analisedadosensino.leaf.Fisico;
import com.aps2.analisedadosensino.leaf.Matematico;
import com.aps2.analisedadosensino.leaf.Nivel;
import com.aps2.analisedadosensino.leaf.Outro;
import com.aps2.analisedadosensino.leaf.Quimico;

// Creator
public class FabricaDocente {
    private Docente criaDocente(NomeDisciplina nomeDisciplina, Nivel nivel) {

        switch (nomeDisciplina) {
            case MATEMATICA: return new Matematico(nivel);
            case FISICA: return new Fisico(nivel);
            case QUIMICA: return new Quimico(nivel);

            default: return new Outro(nivel);
        }
    }

    public Docente criaDocente(ReaderClient professor)
    {
    	var possuiDoutorado = parseBoolean(professor.getIN_DOUTORADO());
		var possuiMestrado = parseBoolean(professor.getIN_MESTRADO());
		var possuiPos = !parseBoolean(professor.getIN_POS_NENHUM());
		var possuiGraduacao = parseBoolean(professor.getIN_POS_NENHUM());
		
		var eMatematico = parseBoolean(professor.getIN_DISC_MATEMATICA());
		var eFisico = parseBoolean(professor.getIN_DISC_FISICA());
		var eQuimico = parseBoolean(professor.getIN_DISC_QUIMICA());
		
		Nivel nivel;
		
		if (possuiDoutorado)
			nivel = Nivel.DOUTORADO;
		else if (possuiMestrado)
			nivel = Nivel.MESTRADO;
		else if (possuiPos)
			nivel = Nivel.POS_GRADUAÇÃO;
		else if (possuiGraduacao)
			nivel = Nivel.GRADUAÇÃO;
		else
			nivel = Nivel.SEM_INFORMAÇÃO;
		
		Docente docente;
		
		if (eMatematico) {
			docente = criaDocente(MATEMATICA, nivel);
		} else if (eFisico) {
			docente = criaDocente(FISICA, nivel);
		} else if (eQuimico) {
			docente = criaDocente(QUIMICA, nivel);
		} else {
			docente = criaDocente(OUTRAS, nivel);
		}
    	
    	return docente;
    }
}
