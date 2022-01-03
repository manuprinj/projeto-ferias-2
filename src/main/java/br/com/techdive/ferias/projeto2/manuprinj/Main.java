package br.com.techdive.ferias.projeto2.manuprinj;


import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getData;
import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getIdentificacao;
import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getInt;
import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getQuantidadeAlunos;
import static br.com.techdive.ferias.projeto2.manuprinj.utils.EntradaUtils.getString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;


public class Main {

    public static List<Turma> turmas = new ArrayList<>();
    public static List<Docente> docentes = new ArrayList<>();
    static int identificacaoTurma = 0;
    static int identificacaoDocente = 0;

    public static void menu() {
        int tipoOperacao = 0;
        while (tipoOperacao != 7) {
            System.out.println("Seja bem-vindo ao Sistema Gerencial TechDive");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Cadastrar Docentes");
            System.out.println("3 - Alocar Docente");
            System.out.println("4 - Listar Turmas");
            System.out.println("5 - Listar Docentes");
            System.out.println("6 - Listar Docente Específico");
            System.out.println("7 - Sair");
            tipoOperacao = getInt();

            if (tipoOperacao < 1 || tipoOperacao > 7) {
                System.out.println("Digite uma opção válida!!");
                menu();
            }
            if (tipoOperacao == 1) cadastrarTurma();
            if (tipoOperacao == 2) cadastrarDocente();
            if (tipoOperacao == 3) cadastrarDocenteParaTurma();
            if (tipoOperacao == 4) Listas.listarTodasTurmas();
            if (tipoOperacao == 5) Listas.listarTodosDocentes();
            if (tipoOperacao == 6) ;
            if (tipoOperacao == 7) ;
        }
    }

    public static void cadastrarTurma() {

        int identificacaoTurma = getIdentificacao("Digite o número de identificação da turma: ");

        String nomeTurma = getString("Digite o nome da turma: ");

        int quantidadeAlunos = getQuantidadeAlunos("Digite a quantidade de alunos: ");

        LocalDate dataInicio = getData("Digite a data de início das aulas (dd/MM/yyyy): ");

        Turma turma = new Turma(identificacaoTurma, nomeTurma, quantidadeAlunos, dataInicio);
        turmas.add(turma);
    }

    public static Turma validacaoTurma() {
        identificacaoTurma = getIdentificacao("Digite o número de identificação da turma: ");

        for (Turma turma : turmas) {
            if (turma.getIdentificacoTurma() == identificacaoTurma) return turma;
        }

        System.out.println("Turma não encontrado!");
        return null;
    }

    public static void cadastrarDocente() {
        int tipoOperacao = 0;

        int identificacaoDocente = getIdentificacao("Digite o número de identificação do docente: ");

        String nomeDocente = getString("Digite o nome do docente: ");

        System.out.println("O docente está atendendo alguma turma atualmente?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        tipoOperacao = getInt();

        if (tipoOperacao < 1 || tipoOperacao > 2) {
            System.out.println("Digite uma opção válida!!");
            menu();
        }
        if (tipoOperacao == 1) {
            Turma turma = validacaoTurma();
            if (turma == null) cadastrarDocente();
            else {
                Docente docente = new Docente(identificacaoDocente, nomeDocente, identificacaoTurma);
                docentes.add(docente);
            }
        } else {
            Docente docente = new Docente(identificacaoDocente, nomeDocente);
            docentes.add(docente);
        }
    }

    public static Docente validacaoDocente() {
        identificacaoDocente = getIdentificacao("Digite o número de identificação do docente: ");

        for (Docente docente : docentes) {
            if (docente.getIdentificacaoDocente() == identificacaoDocente) return docente;
        }

        System.out.println("Docente não encontrado!");
        return null;
    }

    public static void cadastrarDocenteParaTurma() {

        Turma turma = validacaoTurma();
        if (turma == null) cadastrarDocenteParaTurma();
        else {
            Docente docente = validacaoDocente();
            if (docente == null) cadastrarDocenteParaTurma();
            else {
                for (Docente docente1 : docentes) {
                    if (docente1.getIdentificacaoDocente() == identificacaoDocente) {
                        docente1.setCodigoTurma(identificacaoTurma);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
