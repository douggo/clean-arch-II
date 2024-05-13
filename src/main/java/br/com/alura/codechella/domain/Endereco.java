package br.com.alura.codechella.domain;

import java.util.Objects;

public class Endereco {

    private final String cep;
    private final int numero;
    private final String complemento;

    public Endereco(String cep, int numero, String complemento) {
        Validator.validateAll(cep, numero, complemento);
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    static class Validator {

        public static void validateAll(String cep, int numero, String complemento) {
            validateCep(cep);
            validateNumero(numero);
            validateComplemento(complemento);
        }

        private static void validateCep(String cep) throws IllegalArgumentException {
            if (!Objects.isNull(cep) && cep.matches("\\d{5}-\\d{3}")) {
                return;
            }
            throw new IllegalArgumentException("CEP informado não está no formato padrão");
        }

        private static void validateNumero(int numero) throws IllegalArgumentException {
            if (numero > 0) {
                return;
            }
            throw new IllegalArgumentException("Número do endereço precisa ser informado!");
        }

        private static void validateComplemento(String complemento) {
            if (!Objects.isNull(complemento) && complemento.length() > 3) {
                return;
            }
            throw new IllegalArgumentException("Complemento precisa pelo menos três (3) caracteres!");
        }

    }

}