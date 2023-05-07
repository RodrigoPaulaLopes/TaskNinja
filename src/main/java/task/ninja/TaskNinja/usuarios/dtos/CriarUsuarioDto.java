package task.ninja.TaskNinja.usuarios.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import task.ninja.TaskNinja.usuarios.entidades.Usuarios;
import task.ninja.TaskNinja.usuarios.pessoas.dtos.CriarPessoasDto;

public record CriarUsuarioDto(@NotBlank String login, @NotBlank String senha, @NotNull @Valid CriarPessoasDto pessoas) {

    public CriarUsuarioDto(Usuarios usuario){
        this(usuario.getLogin(), usuario.getSenha(), new CriarPessoasDto(usuario.getPessoa().getNome(), usuario.getPessoa().getData_nascimento(), usuario.getPessoa().getCpf(), usuario.getPessoa().getEmail(), usuario.getPessoa().getSexo()));
    }
}
