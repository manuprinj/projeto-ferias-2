package br.com.techdive.ferias.projeto2.manuprinj.assuntos;


public enum TiposAssuntos {
    JAVA("Java"),
    JAVASCRIPT("Javascript"),
    HTLM("HTML"),
    CSS("CSS"),
    GROOVY("Groovy"),
    REACT("React");

    private final String nome;

    TiposAssuntos(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
