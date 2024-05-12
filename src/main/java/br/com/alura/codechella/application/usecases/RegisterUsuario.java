package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateway.UsuarioUseCaseRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class RegisterUsuario  {

    private final UsuarioUseCaseRepository repository;

    public RegisterUsuario(UsuarioUseCaseRepository repository) {
        this.repository = repository;
    }

    public Usuario registerUsuario(Usuario usuario) {
        return this.repository.register(usuario);
    }
}