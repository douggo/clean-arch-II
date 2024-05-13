package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.time.LocalDate;

public record UsuarioDto(
        String cpf,
        String nome,
        LocalDate nascimento,
        String email
) {

    public Usuario toDomain() {
        return new Usuario(
                this.cpf,
                this.nome,
                this.nascimento,
                this.email
        );
    }

    public static UsuarioDto fromDomain(Usuario usuario) {
        return new UsuarioDto(
                usuario.getCpf(),
                usuario.getNome(),
                usuario.getNascimento(),
                usuario.getEmail()
        );
    }
}