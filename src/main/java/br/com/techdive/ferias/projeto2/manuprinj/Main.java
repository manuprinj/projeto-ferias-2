package br.com.techdive.ferias.projeto2.manuprinj;


import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getData;
import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getIdentificacao;
import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getInt;
import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getQuantidadeAlunos;
import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.techdive.ferias.projeto2.manuprinj.assuntos.TiposAssuntos;


public class Main {

    public static List<Turma> turmas = new ArrayList<>();
    public static List<Docente> docentes = new ArrayList<>();
    static int identificacaoTurma = 0;
    static int identificacaoDocente = 0;

    public static void menu() {
        while (true) {
            System.out.println("Seja bem-vindo ao Sistema Gerencial TechDive");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Cadastrar Docente");
            System.out.println("3 - Alocar Docente");
            System.out.println("4 - Listar Turmas Com Assuntos, Docentes e Semanas");
            System.out.println("5 - Listar Todos os Docentes");
            System.out.println("6 - Listar Docente Específico");
            System.out.println("7 - Sair");
            int tipoOperacao = getInt();

            if (tipoOperacao == 1) cadastrarTurma();
            else if (tipoOperacao == 2) cadastrarDocente();
            else if (tipoOperacao == 3) cadastrarDocenteParaTurma();
            else if (tipoOperacao == 4) Listas.listarTodasTurmarComInformacoesCompletas();
            else if (tipoOperacao == 5) Listas.listarTodosDocentes();
            else if (tipoOperacao == 6) listarDocenteComSemanas();
            else if (tipoOperacao == 7) return;
            else System.out.println("Digite uma opção válida!!");

        }
    }

    public static void cadastrarTurma() {

        int identificacaoTurma = getIdentificacao("Digite o número de identificação da turma: ");
        for (Turma turma : turmas) {
            if (turma.getIdentificacoTurma() == identificacaoTurma) {
                System.out.println("Este número de identificação de turma já existe!");
                return;
            }
        }

        String nomeTurma = getString("Digite o nome da turma: ");

        int quantidadeAlunos = getQuantidadeAlunos("Digite a quantidade de alunos: ");

        LocalDate dataInicio = getData("Digite a data de início das aulas (dd/MM/yyyy): ");

        System.out.println("Selecione o assunto da turma:");
        for (TiposAssuntos value : TiposAssuntos.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoAssunto = getInt() - 1;
        TiposAssuntos assunto = TiposAssuntos.values()[opcaoAssunto];

        Turma turma = new Turma(identificacaoTurma, nomeTurma, quantidadeAlunos, dataInicio, assunto);
        turmas.add(turma);
    }

    public static Turma validacaoTurma() {
        while (true) {
            identificacaoTurma = getIdentificacao("Digite o número de identificação da turma: ");

            for (Turma turma : turmas) {
                if (turma.getIdentificacoTurma() == identificacaoTurma) return turma;
            }

            System.out.println("Turma não encontrada!");
        }
    }

    public static void cadastrarDocente() {

        int identificacaoDocente = getIdentificacao("Digite o número de identificação do docente: ");
        for (Docente docente : docentes) {
            if (docente.getIdentificacaoDocente() == identificacaoDocente) {
                System.out.println("Este número de identificação de docente já existe!");
                return;
            }
        }

        String nomeDocente = getString("Digite o nome do docente: ");

        int tipoOperacao = 2;
        if (!turmas.isEmpty()) {
            System.out.println("O docente está atendendo alguma turma atualmente?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            tipoOperacao = getInt();
        }

        if (tipoOperacao == 1) {
            Turma turma = validacaoTurma();
            if (turma.getDocentes().size() >= 2) {
                System.out.println("Esta turma já tem o número máximo de docentes.");
                return;
            }
            Docente docente = new Docente(identificacaoDocente, nomeDocente, identificacaoTurma);
            docentes.add(docente);
            turma.getDocentes().add(docente);
        } else if (tipoOperacao == 2) {
            Docente docente = new Docente(identificacaoDocente, nomeDocente);
            docentes.add(docente);
        } else System.out.println("Digite uma opção válida!!");

    }

    public static Docente validacaoDocente() {
        while (true) {
            identificacaoDocente = getIdentificacao("Digite o número de identificação do docente: ");

            for (Docente docente : docentes) {
                if (docente.getIdentificacaoDocente() == identificacaoDocente) return docente;
            }

            System.out.println("Docente não encontrado!");
        }
    }

    public static void cadastrarDocenteParaTurma() {

        Turma turma = validacaoTurma();
        if (turma.getDocentes().size() >= 2) {
            System.out.println("Esta turma já tem o número máximo de docentes.");
            return;
        }
        Docente docente = validacaoDocente();
        for (Docente docente1 : docentes) {
            if (docente1.getIdentificacaoDocente() == identificacaoDocente) {
                turma.getDocentes().add(docente);
                docente1.setCodigoTurma(identificacaoTurma);
            }
        }
    }

    public static void listarDocenteComSemanas() {
        Docente docente = validacaoDocente();
        Listas.listarDocenteEspecifico(docente);
    }

    public static void main(String[] args) {
        menu();
    }
}
