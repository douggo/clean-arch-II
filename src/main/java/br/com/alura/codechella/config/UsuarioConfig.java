package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateway.UsuarioUseCaseRepository;
import br.com.alura.codechella.application.usecases.ListUsuarios;
import br.com.alura.codechella.application.usecases.RegisterUsuario;
import br.com.alura.codechella.infra.gateway.UsuarioMapper;
import br.com.alura.codechella.infra.gateway.UsuarioUseCaseJPARepository;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    RegisterUsuario createRegisterUsuarioUseCase(UsuarioUseCaseRepository useCaseRepository) {
        return new RegisterUsuario(useCaseRepository);
    }

    @Bean
    ListUsuarios createListUsuariosUseCase(UsuarioUseCaseRepository useCaseRepository) {
        return new ListUsuarios(useCaseRepository);
    }

    @Bean
    UsuarioUseCaseJPARepository createUsuarioUseCaseJPARepository(UsuarioRepository persistenceRepository, UsuarioMapper mapper) {
        return new UsuarioUseCaseJPARepository(persistenceRepository, mapper);
    }

    @Bean
    UsuarioMapper createUsuarioMapper() {
        return new UsuarioMapper();
    }

}