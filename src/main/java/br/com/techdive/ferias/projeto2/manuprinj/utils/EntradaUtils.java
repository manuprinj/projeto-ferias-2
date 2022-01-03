package br.com.techdive.ferias.projeto2.manuprinj.utils;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class EntradaUtils {

    public static final Scanner SC = new Scanner(System.in);
    public static final String VALOR_INVALIDO = "Valor inválido!";

    public static double getDouble(String mensagem) {
        Double valor = null;
        while (valor == null) {
            System.out.println(mensagem);
            try {
                valor = Double.parseDouble(SC.nextLine().replace(",", "."));
            } catch (Exception e) {
                System.out.println(VALOR_INVALIDO);
            }
        }
        return valor;
    }

    public static int getInt() {
        Integer valor = null;
        while (valor == null) {
            try {
                valor = Integer.parseInt(SC.nextLine());
            } catch (Exception e) {
                System.out.println(VALOR_INVALIDO);
            }
        }
        return valor;
    }

    public static String getString(String mensagem) {
        String valor = "";
        while (valor.isBlank()) {
            System.out.println(mensagem);
            valor = SC.nextLine();
        }
        return valor;
    }

    public static int getIdentificacao(String mensagem) {
        Integer valor = null;
        while (valor == null) {
            try {
                System.out.println(mensagem);
                valor = SC.nextInt();
                SC.nextLine();
            } catch (Exception e) {
                System.out.println(VALOR_INVALIDO);
            }
        }
        return valor;
    }

    public static int getQuantidadeAlunos(String mensagem) {
        Integer valor = null;
        while (valor == null) {
            try {
                System.out.println(mensagem);
                valor = SC.nextInt();
                SC.nextLine();
            } catch (Exception e) {
                System.out.println(VALOR_INVALIDO);
            }
        }
        return valor;
    }

    public static LocalDate getData(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                return DataUtils.parse(SC.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida, digite a data no formato dd/MM/yyyy");
            }
        }
    }
}
