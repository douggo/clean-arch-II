package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.ListUsuarios;
import br.com.alura.codechella.application.usecases.RegisterUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final RegisterUsuario registerUsuarioUseCase;
    private final ListUsuarios listUsuariosUseCase;

    public UsuarioController(RegisterUsuario registerUsuarioUseCase, ListUsuarios listUsuariosUseCase) {
        this.registerUsuarioUseCase = registerUsuarioUseCase;
        this.listUsuariosUseCase = listUsuariosUseCase;
    }

    @PostMapping
    public UsuarioDto registerUsuario(@RequestBody UsuarioDto dto) {
        return UsuarioDto.fromDomain(this.registerUsuarioUseCase.execute(dto.toDomain()));
    }

    @GetMapping
    public List<UsuarioDto> listAllUsuarios() {
        return this.listUsuariosUseCase.execute()
                .stream()
                .map(UsuarioDto::fromDomain)
                .toList();
    }

}