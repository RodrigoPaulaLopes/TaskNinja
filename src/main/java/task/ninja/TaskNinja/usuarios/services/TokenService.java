package task.ninja.TaskNinja.usuarios.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;
import task.ninja.TaskNinja.usuarios.entidades.Usuarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private String secret = "123456n78";

    public String gerarToken(Usuarios usuario) {
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            var token = JWT.create()
                    .withIssuer("taskninja")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algoritimo);
            return token;
        } catch (JWTVerificationException e) {
            throw new RuntimeException("erro ao gerar token jwt", e);
        }
    }

    public String getSubject(String token) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            var tokenSubject = JWT.require(algoritmo)
                    .withIssuer("taskninja")
                    .build()
                    .verify(token)
                    .getSubject();
            return tokenSubject;
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Erro ao verificar token " + e);
        }
    }

}
