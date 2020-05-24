package com.aps2.analisedadosensino.client;

import static com.aps2.analisedadosensino.NomeDisciplina.MATEMATICA;
import static com.aps2.analisedadosensino.Utils.BREAK_LINE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aps2.analisedadosensino.composite.Regiao;
import com.aps2.analisedadosensino.factory.FabricaDocente;


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

            	try {
            		var docente = fabricaDocente.criaDocente(professor);
            		regiao.adiciona(docente);
            	}
            	catch(IllegalArgumentException e) {
            		continue;
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
