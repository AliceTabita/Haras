package br.com.haras.model.valid;

import br.com.haras.model.valid.exceptions.InvalidCpfException;

public class CPFValidator {
    public static boolean isValidCPF(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");


        if (cpf.length() != 11) {
            throw new InvalidCpfException("CPF Inválido");
        }

        boolean todosDigitosIguais = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }

        if (todosDigitosIguais) {
           throw new InvalidCpfException("CPF Inválido - todos os digitos iguais");
        }


        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = cpf.charAt(i) - '0';
        }

        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += digitos[i] * (10 - i);
        }

        int resto1 = soma1 % 11;
        int dv1 = (resto1 < 2) ? 0 : 11 - resto1;

        if (digitos[9] != dv1) {
            throw new InvalidCpfException("CPF Inválido");
        }

        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += digitos[i] * (11 - i);
        }

        int resto2 = soma2 % 11;
        int dv2 = (resto2 < 2) ? 0 : 11 - resto2;
        if(!(digitos[10] == dv2)){
            throw new InvalidCpfException("CPF Inválido");
        }
        return true;
    }
}
