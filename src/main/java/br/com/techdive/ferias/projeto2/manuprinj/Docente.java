package br.com.techdive.ferias.projeto2.manuprinj;


import java.util.StringJoiner;



public class Docente {
    private int identificacaoDocente;
    private String nomeDocente;
    private int codigoTurma;

    public Docente(int identificacaoDocente, String nomeDocente) {
        this.identificacaoDocente = identificacaoDocente;
        this.nomeDocente = nomeDocente;
    }

    public Docente(int identificacaoDocente, String nomeDocente, int codigoTurma) {
        this.identificacaoDocente = identificacaoDocente;
        this.nomeDocente = nomeDocente;
        this.codigoTurma = codigoTurma;
    }

    @Override
    public String toString () {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("Identificação Docente: " + getIdentificacaoDocente())
                .add("Nome: " + getNomeDocente())
                .add("Identificação Turma: " + getCodigoTurma());

        return joiner.toString();
    }

    public int getIdentificacaoDocente() {
        return identificacaoDocente;
    }

    public void setIdentificacaoDocente(int identificacaoDocente) {
        this.identificacaoDocente = identificacaoDocente;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }
}
