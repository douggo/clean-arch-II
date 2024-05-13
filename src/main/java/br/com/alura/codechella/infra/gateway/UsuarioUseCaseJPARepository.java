package br.com.alura.codechella.infra.gateway;

import br.com.alura.codechella.application.gateway.UsuarioUseCaseRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioUseCaseJPARepository implements UsuarioUseCaseRepository {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioUseCaseJPARepository(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Usuario> listAll() {
        return this.repository.findAll().stream().map(UsuarioEntity::toDomain).toList();
    }

    @Override
    public Usuario register(Usuario usuario) {
        this.repository.save(this.mapper.toEntity(usuario));
        return usuario;
    }

}