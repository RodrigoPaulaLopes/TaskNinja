package task.ninja.TaskNinja.tarefas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import task.ninja.TaskNinja.tarefas.entidades.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}
