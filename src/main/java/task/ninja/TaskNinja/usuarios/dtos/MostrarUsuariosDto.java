package task.ninja.TaskNinja.usuarios.dtos;

import task.ninja.TaskNinja.usuarios.entidades.Usuarios;
import task.ninja.TaskNinja.usuarios.pessoas.Pessoas;

public record MostrarUsuariosDto(Long id, String login, Pessoas pessoas) {

    public MostrarUsuariosDto(Usuarios usuarios){
        this(usuarios.getId(), usuarios.getLogin(), usuarios.getPessoa());
    }
}
