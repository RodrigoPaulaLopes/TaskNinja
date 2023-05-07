package task.ninja.TaskNinja.tarefas.entidades;

import jakarta.persistence.*;
import lombok.*;
import task.ninja.TaskNinja.tarefas.dtos.AtualizarTarefaDto;
import task.ninja.TaskNinja.tarefas.dtos.CriarTarefaDto;
import task.ninja.TaskNinja.tarefas.enuns.Prioridade;
import task.ninja.TaskNinja.tarefas.enuns.Status;
import task.ninja.TaskNinja.usuarios.entidades.Usuarios;

import java.util.Date;

@Entity(name = "tarefas")
@Table(name = "tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Tarefas {



    public Tarefas(CriarTarefaDto tarefaDto){
        this.setNome(tarefaDto.nome());
        this.setDescricao(tarefaDto.descricao());
        this.setPrazo(tarefaDto.prazo());
        this.setStatus(tarefaDto.status());
        this.setPrioridade(tarefaDto.prioridade());
        this.setUsuario(new Usuarios(tarefaDto.usuario()));
    }
    public Tarefas(AtualizarTarefaDto tarefaDto){
        this.setId(tarefaDto.id());
        this.setNome(tarefaDto.nome());
        this.setDescricao(tarefaDto.descricao());
        this.setPrazo(tarefaDto.prazo());
        this.setStatus(tarefaDto.status());
        this.setPrioridade(tarefaDto.prioridade());
        this.setUsuario(new Usuarios(tarefaDto.usuario()));
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Date prazo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios usuario;

    public void atualizarDados(AtualizarTarefaDto tarefa) {
        this.setId(tarefa.id());
        this.setNome(tarefa.nome());
        this.setDescricao(tarefa.descricao());
        this.setStatus(tarefa.status());
        this.setPrazo(tarefa.prazo());
        this.setPrioridade(tarefa.prioridade());
        this.setUsuario(new Usuarios(tarefa.usuario()));
    }
}
