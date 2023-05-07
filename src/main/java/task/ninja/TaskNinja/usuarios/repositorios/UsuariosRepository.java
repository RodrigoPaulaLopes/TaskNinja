package task.ninja.TaskNinja.usuarios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import task.ninja.TaskNinja.usuarios.entidades.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    UserDetails findByLogin(String username);
}
