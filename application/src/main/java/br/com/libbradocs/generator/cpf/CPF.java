package br.com.libbradocs.generator.cpf;

import br.com.libbradocs.generator.uf.UF;

import java.util.Random;
import java.util.Arrays;

public class CPF {
    private CPF() {
    }


    public static class Builder {

        private static final Random RANDOM = new Random();
        private Integer[] number = new Integer[11];

        public Builder digito(int position, int value) {
            number[position] = value;
            return this;
        }

        public Builder digito(String digits) {

            if (digits.length() > 9) {
                digits = digits.substring(0, 9);
            }

            for (int i = 0; i < digits.length(); i++) {
                if (Character.isDigit(digits.substring(i, i + 1).toCharArray()[0])) {
                    number[i] = Integer.valueOf(digits.substring(i, i + 1));
                }
            }

            return this;
        }

        public Builder digito(Long digitos) {
            return digito(String.valueOf(digitos));
        }

        public Builder regiao(UF uf) {
            number[8] = uf.getDigitoRegiao();
            return this;
        }

        public String get() {
            for (int i = 0; i < 9; i++) {
                if (number[i] == null) {
                    number[i] = RANDOM.nextInt(10);
                }
            }
            
            return Arrays.stream(calcularDigitosVerificadores(number))
                    .map(String::valueOf)
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        }

        public static Integer[] calcularDigitosVerificadores(Integer[] cpfBase) {
            Integer[] cpfCompleto = Arrays.copyOf(cpfBase, 11);

            // Calcula o primeiro dígito verificador
            cpfCompleto[9] = calcularDigitoVerificador(cpfCompleto, 10);

            // Calcula o segundo dígito verificador
            cpfCompleto[10] = calcularDigitoVerificador(cpfCompleto, 11);

            return cpfCompleto;
        }

        public static int calcularDigitoVerificador(Integer[] cpf, int posicao) {
            int soma = 0;
            int peso = posicao;

            for (int i = 0; i < cpf.length; i++) {
                Integer digito = cpf[i];
                if (digito == null) {
                    digito = 0; // Substitui valor null por 0
                }
                soma += digito * peso;
                peso--;
            }

            int resto = soma % 11;
            int digitoVerificador = (resto < 2) ? 0 : (11 - resto);

            return digitoVerificador;
        }


    }
}
