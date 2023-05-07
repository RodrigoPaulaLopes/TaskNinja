package task.ninja.TaskNinja.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import task.ninja.TaskNinja.tarefas.dtos.AtualizarTarefaDto;
import task.ninja.TaskNinja.tarefas.dtos.CriarTarefaDto;
import task.ninja.TaskNinja.tarefas.dtos.MostrarTarefasDto;
import task.ninja.TaskNinja.tarefas.entidades.Tarefas;
import task.ninja.TaskNinja.tarefas.repositorios.TarefasRepository;

import java.util.List;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    @Autowired
    private TarefasRepository repository;

    @GetMapping
    public ResponseEntity<Page<MostrarTarefasDto>> findAll(Pageable paginacao) {
        return ResponseEntity.ok().body(this.repository.findAll(paginacao).map(MostrarTarefasDto::new));

    }



    @GetMapping("/{id}")
    public ResponseEntity<MostrarTarefasDto> findById(@PathVariable Long id) {
        var tarefa = this.repository.getReferenceById(id);


        return ResponseEntity.ok().body(new MostrarTarefasDto(tarefa));

    }

    @PostMapping
    public ResponseEntity<MostrarTarefasDto> create(@RequestBody CriarTarefaDto tarefaDto, UriComponentsBuilder uriBuilder) {
        var tarefa = new Tarefas(tarefaDto);
        this.repository.save(tarefa);
        var uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(uri).body(new MostrarTarefasDto(tarefa));

    }
    @PutMapping
    public ResponseEntity<MostrarTarefasDto> update(@RequestBody AtualizarTarefaDto tarefaDto) {
        var tarefa = this.repository.getReferenceById(tarefaDto.id());
        tarefa.atualizarDados(tarefaDto);

        this.repository.save(tarefa);
        return ResponseEntity.ok(new MostrarTarefasDto(tarefa));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        var tarefa = this.repository.getReferenceById(id);

        this.repository.delete(tarefa);

        return ResponseEntity.noContent().build();

    }
}
