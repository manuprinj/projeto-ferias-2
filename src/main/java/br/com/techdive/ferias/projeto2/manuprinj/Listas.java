package br.com.techdive.ferias.projeto2.manuprinj;


public class Listas {

    public static void listarTodosDocentes() {
        for (Docente docente : Main.docentes) {
            System.out.println(docente);
        }
    }

    public static void listarTodasTurmarComInformacoesCompletas() {
        for (Turma turma : Main.turmas) {
            System.out.println(turma);
            System.out.println("Docentes: ");
            for (int i = 0; i < turma.getDocentes().size(); i++) {
                if (turma.getDocentes().size() == 1) {
                    System.out.print("SEG | TER | QUA | QUI | SEX ");
                } else if (i == 0){
                    System.out.print("SEG | TER ");
                } else {
                    System.out.print("QUA | QUI | SEX ");
                }
                System.out.println(turma.getDocentes().get(i));
            }
            System.out.println();
        }
    }
}
