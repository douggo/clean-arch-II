package br.com.alura.codechella.infra.gateway;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

public class UsuarioMapper {

    public UsuarioEntity toEntity(Usuario usuario) {
        return UsuarioEntity.fromUsuario(usuario);
    }

    public Usuario toDomain(UsuarioEntity usuario) {
        return UsuarioEntity.toDomain(usuario);
    }

}