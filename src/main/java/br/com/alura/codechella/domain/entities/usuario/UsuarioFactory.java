package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;

public class UsuarioFactory {

    public static Usuario create(String cpf, String nome, LocalDate nascimento, String email) {
        return new Usuario(cpf, nome, nascimento, email);
    }

    public static Usuario createWithEndereco(String cpf, String nome, LocalDate nascimento, String email, String cep, int numero, String complemento) {
        Usuario usuario = create(cpf, nome, nascimento, email);
        usuario.setEndereco(new Endereco(cep, numero, complemento));
        return usuario;
    }

}
