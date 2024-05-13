package br.com.alura.codechella.infra.gateway;

import br.com.alura.codechella.application.gateway.UsuarioUseCaseRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioUseCaseMemoryRepository implements UsuarioUseCaseRepository {

    private final List<Usuario> usuarioTable = new ArrayList<>();

    @Override
    public List<Usuario> listAll() {
        return usuarioTable;
    }

    @Override
    public Usuario register(Usuario usuario) {
        this.usuarioTable.add(usuario);
        return usuario;
    }

}