package br.com.techdive.ferias.projeto2.manuprinj;


public class Listas {

    public static void listarTodosDocentes() {
        for (Docente docente : Main.docentes) {
            System.out.println(docente);
        }
    }

    public static void listarTodasTurmarComInformacoesCompletas() {
        for (Turma turma : Main.turmas) {
            System.out.println("Turma: ");
            System.out.println(turma);
            System.out.println("Docente(s): ");
            for (int i = 0; i < turma.getDocentes().size(); i++) {
                System.out.print(imprimirDiaDaSemana(turma, i) + " - ");
                System.out.println(turma.getDocentes().get(i));
            }
            System.out.println();
        }
    }

    private static String imprimirDiaDaSemana(Turma turma, int i) {
        if (turma.getDocentes().size() == 1) {
            return "SEG | TER | QUA | QUI | SEX";
        } else if (i == 0){
            return "SEG | TER";
        }
        return "QUA | QUI | SEX";
    }

    public static void listarDocenteEspecifico(Docente docente) {
        System.out.println(docente);
        for (Turma turma : Main.turmas) {
            if (turma.getIdentificacoTurma() == docente.getCodigoTurma()) {
                System.out.println(turma);
                for (int i = 0; i < turma.getDocentes().size(); i++) {
                    if (turma.getDocentes().get(i).getIdentificacaoDocente() == docente.getIdentificacaoDocente()) {
                        System.out.println("Dias da semana: " + imprimirDiaDaSemana(turma, i));
                    }
                }
            }
        }
    }
}
