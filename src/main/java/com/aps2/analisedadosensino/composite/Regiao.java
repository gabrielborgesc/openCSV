package com.aps2.analisedadosensino.composite;

import static com.aps2.analisedadosensino.NomeDisciplina.MATEMATICA;
import static com.aps2.analisedadosensino.Utils.BREAK_LINE;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aps2.analisedadosensino.Disciplina;
import com.aps2.analisedadosensino.NomeDisciplina;
import com.aps2.analisedadosensino.component.Docente;
import com.aps2.analisedadosensino.leaf.Nivel;

public class Regiao implements Docente {

    private String nome;
    private List<Disciplina> disciplinas = this.iniciaDisciplinas();

    public Regiao(String nome) {
        this.nome = nome;
    }

    @Override
    public Nivel getNivel() {
        return null;
    }

    @Override
    public NomeDisciplina getNomeDisciplina() {
        return null;
    }

    @Override
    public String analisa() {
        return "Região " + this.nome + ":" + BREAK_LINE +
                disciplinas
                        .stream()
                        .map(Disciplina::analisa)
                        .collect(Collectors.joining(BREAK_LINE)) +
                BREAK_LINE;
    }

    private List<Disciplina> iniciaDisciplinas() {
        var disciplinas = new ArrayList<Disciplina>();
        Arrays.stream(NomeDisciplina.values())
                .forEach(nomeDisciplina ->
                        disciplinas.add(new Disciplina(nomeDisciplina))
                );

        return disciplinas;
    }


//    @Override
//    public String analisa() {
//        String s = "";
//
//        for (String nome : nomesDisciplinas) {
//            disciplinas.add(new Disciplina(nome));
//        }
//
//        String aux;
//
//        for (Docente docente : docentes) {
//
//            aux = docente.analisa();
//
//            if (aux.startsWith("m")) {
//                disciplinas.set(0, disciplinas.get(0).add(aux.substring(1)));
//            } else if (aux.startsWith("f")) {
//                disciplinas.set(1, disciplinas.get(1).add(aux.substring(1)));
//            } else if (aux.startsWith("q")) {
//                disciplinas.set(2, disciplinas.get(2).add(aux.substring(1)));
//            } else {
//                disciplinas.set(3, disciplinas.get(3).add(aux.substring(1)));
//            }
//        }
//
//        disciplinas.set(0, disciplinas.get(0).calculate());
//
//        s += "\n\nRegião " + nome + ":\n";
//        for (int i = 0; i < disciplinas.size(); i++) {
//            s += disciplinas.get(i).getNome() + ":\n";
//            s += "Quantidade total de docentes: " + disciplinas.get(i).getQtotal() + "\n";
//            s += "Docentes com apenas graduação: " + disciplinas.get(i).getQgraduacao() + "\n";
//            s += "Docentes com apenas pós graduação: " + disciplinas.get(i).getQpos() + "\n";
//            s += "Docentes mestres: " + disciplinas.get(i).getQmestrado() + "\n";
//            s += "Docentes doutores: " + disciplinas.get(i).getQdoutorado() + "\n";
//            s += "Sem informação: " + disciplinas.get(i).getQseminfo() + "\n\n\n";
//        }
//        return s;

//    }

    public String porcentagemComAlgumaPosGraduacao(NomeDisciplina nomeDisciplina) {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Porcentagem de pós-graduados em " +
                nomeDisciplina.toString().toLowerCase() +
                " na Região " + this.nome + ": " +
                df.format(this.getDisciplinaPorNome(MATEMATICA).getPorcentagemComAlgumaPosGraduacao()) +
                "%" + BREAK_LINE;
    }

    public void adiciona(Docente docente) {
        var disciplina = this.getDisciplinaPorNome(docente.getNomeDisciplina());
        disciplina.adiciona(docente);
    }

    public void adiciona(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    private Disciplina getDisciplinaPorNome(NomeDisciplina nome) {
        return this.disciplinas.stream()
                .filter(disciplina -> disciplina.getNome().equals(nome))
                .findFirst()
                .get();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public void reset() {
//        nome = "";
//        docentes.removeAll(docentes);
//        disciplinas.removeAll(disciplinas);
//    }
}
