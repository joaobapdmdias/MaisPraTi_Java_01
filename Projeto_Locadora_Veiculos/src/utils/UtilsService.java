package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Pessoa;

public class UtilsService {
    public static boolean confereSenha(Pessoa pessoa, String senha) {
        // System.out.println("Senha da pessoa: " + pessoa.getSenha());
        // System.out.println("Senha fornecida: " + senha);
        return pessoa.getSenha().trim().equals(senha.trim());
    }

    public static String normalizaData(LocalDate data) {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
