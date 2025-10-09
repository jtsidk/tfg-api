package tfg.warhammerScanner.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.userdetails.User;

import java.io.IOException;
import java.util.Collections;

@Component
//Recordar que OncePerRequestFilter es una clase abstracta de SpringSecurity que sirve para crear filtros personalizados
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtutil;

    @Override
    protected void doFilterInternal (
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        //Sacamos el header Authorization
        final String authHeader = request.getHeader("Authorization");

        String username = null;
        String token = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtutil.extractUsername(token);
        }

        //3.Validamos y metemos en el contexto si procede
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtutil.validateToken(token, username)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                new User(username, "", Collections.emptyList()), //principal
                                null, //no necesitamos credenciales aqui
                                Collections.emptyList() //Roles vacios de momento
                        );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //Guardamos al usuario autenticado en el contexto de Spring
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        //4.Continuamos con el resto de filtros
        filterChain.doFilter(request, response);
    }
}
