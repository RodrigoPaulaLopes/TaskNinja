package task.ninja.TaskNinja.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import task.ninja.TaskNinja.usuarios.entidades.Usuarios;
import task.ninja.TaskNinja.usuarios.repositorios.UsuariosRepository;
import task.ninja.TaskNinja.usuarios.dtos.AtualizarUsuarioDto;
import task.ninja.TaskNinja.usuarios.dtos.CriarUsuarioDto;
import task.ninja.TaskNinja.usuarios.dtos.MostrarUsuariosDto;

@RestController
@RequestMapping("usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosRepository repository;

    @GetMapping
    public ResponseEntity<Page<MostrarUsuariosDto>> findAll(Pageable paginacao) {
        return ResponseEntity.ok().body(this.repository.findAll(paginacao).map(MostrarUsuariosDto::new));

    }

    @GetMapping("/{id}")
    public ResponseEntity findAll(@PathVariable("id") Long id) {
        var usuario = this.repository.getReferenceById(id);
        return ResponseEntity.ok().body(new MostrarUsuariosDto(usuario));

    }

    @PostMapping
    public ResponseEntity create(@RequestBody CriarUsuarioDto usuarioDto, UriComponentsBuilder uri) {
        var usuario = new Usuarios(usuarioDto);
        this.repository.save(usuario);

        var uriBuilder = uri.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uriBuilder).body(new MostrarUsuariosDto(usuario));

    }

    @PutMapping
    public ResponseEntity create(@RequestBody AtualizarUsuarioDto usuarioDto) {
        var usuario = this.repository.getReferenceById(usuarioDto.id());
        usuario.atualizarDados(usuarioDto);
        this.repository.save(usuario);

        return ResponseEntity.ok().body(new MostrarUsuariosDto(usuario));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        var usuario = this.repository.getReferenceById(id);
        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();

    }
}
