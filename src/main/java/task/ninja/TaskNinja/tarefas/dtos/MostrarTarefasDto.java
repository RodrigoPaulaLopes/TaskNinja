package task.ninja.TaskNinja.tarefas.dtos;

import task.ninja.TaskNinja.tarefas.entidades.Tarefas;
import task.ninja.TaskNinja.tarefas.enuns.Prioridade;
import task.ninja.TaskNinja.tarefas.enuns.Status;
import task.ninja.TaskNinja.usuarios.dtos.MostrarUsuariosDto;
import task.ninja.TaskNinja.usuarios.entidades.Usuarios;

import java.util.Date;
import java.util.List;

public record MostrarTarefasDto(Long id, String nome, String descricao, Date prazo, Status status, Prioridade prioridade, MostrarUsuariosDto usuario) {


    public MostrarTarefasDto(Tarefas tarefa){
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.getPrazo(), tarefa.getStatus(), tarefa.getPrioridade(), new MostrarUsuariosDto(tarefa.getUsuario()));
    }
}
