package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateway.UsuarioUseCaseRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListUsuarios {

    private final UsuarioUseCaseRepository useCaseRepository;

    public ListUsuarios(UsuarioUseCaseRepository useCaseRepository) {
        this.useCaseRepository = useCaseRepository;
    }

    public List<Usuario> execute() {
        return this.useCaseRepository.listAll();
    }

}