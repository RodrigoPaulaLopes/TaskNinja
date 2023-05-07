package task.ninja.TaskNinja.usuarios.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import task.ninja.TaskNinja.tarefas.entidades.Tarefas;
import task.ninja.TaskNinja.usuarios.dtos.AtualizarUsuarioDto;
import task.ninja.TaskNinja.usuarios.dtos.CriarUsuarioDto;
import task.ninja.TaskNinja.usuarios.pessoas.Pessoas;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuarios implements UserDetails {


    public Usuarios(CriarUsuarioDto usuario) {
        this.setLogin(usuario.login());
        this.setSenha(usuario.senha());
        this.setPessoa(new Pessoas(usuario.pessoas()));
    }

    public Usuarios(AtualizarUsuarioDto usuario) {
        this.setId(usuario.id());
        this.setLogin(usuario.login());
        this.setSenha(usuario.senha());
        this.setPessoa(new Pessoas(usuario.pessoas()));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String senha;

    @Embedded
    private Pessoas pessoa;

    @OneToMany(mappedBy = "usuario")
    private List<Tarefas> tarefas;

    public void atualizarDados(AtualizarUsuarioDto usuarioDto) {
        this.setLogin(usuarioDto.login());
        this.setSenha(usuarioDto.senha());
        this.setPessoa(new Pessoas(usuarioDto.pessoas()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.getSenha();
    }

    @Override
    public String getUsername() {
        return this.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
