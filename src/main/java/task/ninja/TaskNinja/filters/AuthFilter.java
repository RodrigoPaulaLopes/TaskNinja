package task.ninja.TaskNinja.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import task.ninja.TaskNinja.usuarios.repositorios.UsuariosRepository;
import task.ninja.TaskNinja.usuarios.services.TokenService;

import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuariosRepository repository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = pegarToken(request);

        if(token != null){
            var subject = tokenService.getSubject(token);
            var usuario = repository.findByLogin(subject);
            var autenticado = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autenticado);
        }
        filterChain.doFilter(request, response);
    }

    public String pegarToken(HttpServletRequest request){
        var token = request.getHeader("Authorization");

        if (token != null){
            return token.replace("Bearer ", "");
        }
        return null;
    }
}
