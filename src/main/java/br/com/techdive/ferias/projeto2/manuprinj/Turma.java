package br.com.techdive.ferias.projeto2.manuprinj;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import br.com.techdive.ferias.projeto2.manuprinj.assuntos.TiposAssuntos;
import br.com.techdive.ferias.projeto2.manuprinj.utils.DataUtils;


public class Turma {

    private int identificacoTurma;
    private String nomeTurma;
    private int quantidadeAlunos;
    private LocalDate dataInicio;
    private TiposAssuntos assunto;
    private List<Docente> docentes = new ArrayList<>();

    public Turma(int identificacoTurma, String nomeTurma, int quantidadeAlunos, LocalDate dataInicio,
            TiposAssuntos assunto) {
        this.identificacoTurma = identificacoTurma;
        this.nomeTurma = nomeTurma;
        this.quantidadeAlunos = quantidadeAlunos;
        this.dataInicio = dataInicio;
        this.assunto = assunto;
    }

    @Override
    public String toString () {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("Identificação: " + getIdentificacoTurma())
                .add("Nome: " + getNomeTurma())
                .add("Quantidade de Alunos: " + getQuantidadeAlunos())
                .add("Data de Início: " + DataUtils.format(getDataInicio()))
                .add("Assunto: " + getAssunto());

        return joiner.toString();
    }

    public int getIdentificacoTurma() {
        return identificacoTurma;
    }

    public void setIdentificacoTurma(int identificacoTurma) {
        this.identificacoTurma = identificacoTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public TiposAssuntos getAssunto() {
        return assunto;
    }

    public void setAssunto(TiposAssuntos assunto) {
        this.assunto = assunto;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }
}
