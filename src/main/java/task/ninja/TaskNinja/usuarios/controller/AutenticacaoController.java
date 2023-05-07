package task.ninja.TaskNinja.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.ninja.TaskNinja.usuarios.dtos.LoginDto;
import task.ninja.TaskNinja.usuarios.dtos.MostrarTokenDto;
import task.ninja.TaskNinja.usuarios.entidades.Usuarios;
import task.ninja.TaskNinja.usuarios.services.TokenService;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginDto dados) {
        var autentication = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var tokenauth = this.manager.authenticate(autentication);

        var token = tokenService.gerarToken((Usuarios) tokenauth.getPrincipal());

        return ResponseEntity.ok().body(new MostrarTokenDto(token));


    }
}
