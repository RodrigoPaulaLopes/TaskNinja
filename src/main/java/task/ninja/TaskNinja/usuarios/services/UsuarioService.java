package task.ninja.TaskNinja.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import task.ninja.TaskNinja.usuarios.repositorios.UsuariosRepository;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuariosRepository reporsitory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.reporsitory.findByLogin(username);
    }
}
