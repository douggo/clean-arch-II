package br.com.alura.codechella.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    private final String cep = "12345-000";
    private final int numero = 999;
    private final String complemento = "Apartamento 103, bloco C";

    @Test
    public void shouldNotCreateEnderecoWithInvalidCep() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco(null, numero, complemento)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco("", numero, complemento)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco("teste", numero, complemento)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco("0000000", numero, complemento)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco("0", numero, complemento)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco("abcde-fg", numero, complemento)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco(String.valueOf(numero), numero, complemento)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco(complemento, numero, complemento)
        );
    }

    @Test
    public void shouldNotCreateEnderecoWithInvalidNumero() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco(cep, 0, complemento)
        );
    }

    @Test
    public void shouldNotCreateEnderecoWithInvalidComplemento() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco(cep, numero, null)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco(cep, numero, "")
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco(cep, numero, " ")
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Endereco(cep, numero, "ad")
        );
    }

    @Test
    public void shouldCreateEnderecoWithValidData() {
        Assertions.assertDoesNotThrow(
                () -> new Endereco(cep, numero, complemento)
        );
    }

}