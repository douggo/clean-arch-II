package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.RegisterUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final RegisterUsuario registerUsuarioUseCase;

    public UsuarioController(RegisterUsuario registerUsuarioUseCase) {
        this.registerUsuarioUseCase = registerUsuarioUseCase;
    }

    @PostMapping
    public UsuarioDto registerUsuario(@RequestBody UsuarioDto dto) {
        return dto.fromDomain(this.registerUsuarioUseCase.registerUsuario(dto.toDomain()));
    }

}