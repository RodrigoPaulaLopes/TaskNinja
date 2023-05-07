package task.ninja.TaskNinja.tarefas.dtos;

import task.ninja.TaskNinja.tarefas.entidades.Tarefas;
import task.ninja.TaskNinja.tarefas.enuns.Prioridade;
import task.ninja.TaskNinja.tarefas.enuns.Status;
import task.ninja.TaskNinja.usuarios.dtos.AtualizarUsuarioDto;
import task.ninja.TaskNinja.usuarios.dtos.MostrarUsuariosDto;

import java.util.Date;

public record CriarTarefaDto(String nome, String descricao, Date prazo, Status status, Prioridade prioridade, AtualizarUsuarioDto usuario) {
    public CriarTarefaDto(Tarefas tarefas){
        this(tarefas.getNome(), tarefas.getDescricao(), tarefas.getPrazo(), tarefas.getStatus(), tarefas.getPrioridade(), new AtualizarUsuarioDto(tarefas.getUsuario()));
    }
}
