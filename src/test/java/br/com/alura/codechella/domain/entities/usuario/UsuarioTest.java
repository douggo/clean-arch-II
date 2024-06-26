package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UsuarioTest {

    private final String nome = "Douglas Felipe Da Silva";
    private final String cpf = "123.456.789-00";
    private final LocalDate nascimento = LocalDate.parse("1997-03-19");
    private final String email = "douglas@alura.com.br";
    private final String cep = "12345-000";
    private final int numero = 999;
    private final String complemento = "Apartamento 103, bloco C";

    @Test
    public void shouldNotCreateUsuarioIfCpfIsInvalid() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario("12345678900", nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario("123.456.789-xx", nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario("abcdefghijk", nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario("abc.def.ghi-jk", nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario("!@#@#@!%&ˆ%ˆ$$#@$%##@", nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario("", nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(null, nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(nome, nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(nascimento.toString(), nome, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(email, nome, nascimento, email)
        );
    }

    @Test
    public void shouldNotCreateUsuarioIfNomeIsInvalid() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, "douglas da silva", nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, "douglas", nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, "do", nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, "", nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, null, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, cpf, nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nascimento.toString(), nascimento, email)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, email, nascimento, email)
        );
    }

    @Test
    public void shouldNotCreateUsuarioIfNascimentoIsNull() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, null, email)
        );
    }

    @Test
    public void shouldNotCreateUsuarioIfEmailIsInvalid() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, nascimento, "douglas.com.br")
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, nascimento, "douglas")
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, nascimento, cpf)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, nascimento, nome)
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, nascimento, nascimento.toString())
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, nascimento, "@")
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, nascimento, "")
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Usuario(cpf, nome, nascimento, null)
        );
    }

    @Test
    public void shouldCreateValidUsuarioIfDataIsValid() {
        Assertions.assertDoesNotThrow(() -> new Usuario(cpf, nome, nascimento, email));
    }

    @Test
    public void shouldCreateValidUsuarioFromFactory() {
        Usuario usuario = UsuarioFactory.create(cpf, nome, nascimento, email);
        Assertions.assertEquals(cpf, usuario.getCpf());
        Assertions.assertEquals(nome, usuario.getNome());
        Assertions.assertEquals(nascimento, usuario.getNascimento());
        Assertions.assertEquals(email, usuario.getEmail());
    }

    @Test
    public void shouldCreateValidUsuarioWithEnderecoFromFactory() {
        Usuario usuario = UsuarioFactory.createWithEndereco(cpf, nome, nascimento, email, cep, numero, complemento);
        Assertions.assertEquals(cpf, usuario.getCpf());
        Assertions.assertEquals(nome, usuario.getNome());
        Assertions.assertEquals(nascimento, usuario.getNascimento());
        Assertions.assertEquals(email, usuario.getEmail());
        Assertions.assertEquals(cep, usuario.getEndereco().getCep());
        Assertions.assertEquals(numero, usuario.getEndereco().getNumero());
        Assertions.assertEquals(complemento, usuario.getEndereco().getComplemento());
    }

}