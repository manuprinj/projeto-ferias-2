package br.com.techdive.ferias.projeto2.manuprinj;


public class Listas {

    public static void listarTodasTurmas() {
        for (Turma turma : Main.turmas) {
            System.out.println(turma);
        }
    }

    public static void listarTodosDocentes() {
        for (Docente docente : Main.docentes) {
            System.out.println(docente);
        }
    }
}
