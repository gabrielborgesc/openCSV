package com.aps2.analisedadosensino.client;

import com.aps2.analisedadosensino.component.Docente;
import com.aps2.analisedadosensino.composite.Regiao;
import com.aps2.analisedadosensino.factory.FabricaDocente;
import com.aps2.analisedadosensino.leaf.Nivel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.aps2.analisedadosensino.NomeDisciplina.*;
import static com.aps2.analisedadosensino.Utils.BREAK_LINE;
import static com.aps2.analisedadosensino.Utils.parseBoolean;


public class Client {

    private static FabricaDocente fabricaDocente = new FabricaDocente();

    public static void main(String args[]) throws IOException {

        ReaderClient reader = new ReaderClient();
        List<ReaderClient> professores = new ArrayList<ReaderClient>();
        String[] nomesRegioes = {"Norte", "Nordeste", "Centro-Oeste", "Sudeste", "Sul"};
        List<Regiao> regioes = new ArrayList<Regiao>();

        StringBuilder result = new StringBuilder(BREAK_LINE);

        for (String nome : nomesRegioes) {///pega as informações das tabelas CSV

            var regiao = new Regiao(nome);
            regioes.add(regiao);

            professores = reader.readCSV(nome);

            for (ReaderClient professor : professores) {

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
                    docente = fabricaDocente.criaDocente(MATEMATICA, nivel);
                    regiao.adiciona(docente);
                } else if (eFisico) {
                    docente = fabricaDocente.criaDocente(FISICA, nivel);
                    regiao.adiciona(docente);
                } else if (eQuimico) {
                    docente = fabricaDocente.criaDocente(QUIMICA, nivel);
                    regiao.adiciona(docente);
                } else {
                    docente = fabricaDocente.criaDocente(OUTRAS, nivel);
                    regiao.adiciona(docente);
                }
            }

            result.append(regiao.analisa());
        }

        regioes.forEach(
                regiao ->
                        result.append(
                                regiao.porcentagemComAlgumaPosGraduacao(MATEMATICA)
                        )
        );

        System.out.println(result);
    }


}
