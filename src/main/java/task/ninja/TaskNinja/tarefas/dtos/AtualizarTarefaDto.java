package task.ninja.TaskNinja.tarefas.dtos;

import task.ninja.TaskNinja.tarefas.entidades.Tarefas;
import task.ninja.TaskNinja.tarefas.enuns.Prioridade;
import task.ninja.TaskNinja.tarefas.enuns.Status;
import task.ninja.TaskNinja.usuarios.dtos.AtualizarUsuarioDto;

import java.util.Date;

public record AtualizarTarefaDto(Long id,String nome, String descricao, Date prazo, Status status, Prioridade prioridade, AtualizarUsuarioDto usuario) {
    public AtualizarTarefaDto(Tarefas tarefa){
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.getPrazo(), tarefa.getStatus(), tarefa.getPrioridade(), new AtualizarUsuarioDto(tarefa.getUsuario()));
    }
}
