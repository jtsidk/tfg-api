package tfg.warhammerScanner.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.mindrot.jbcrypt.BCrypt;
import tfg.warhammerScanner.LoginRequest;
import tfg.warhammerScanner.Repository.UsuarioRepository;
import tfg.warhammerScanner.entity.Usuario;
import tfg.warhammerScanner.security.JwtUtil;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")                 //Evitar problemas para cuando accedan aplicaciones externas a la API
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioRepository.findByEmail(loginRequest.getEmail());

        if (usuario != null && BCrypt.checkpw(loginRequest.getPassword(), usuario.getPasswordHash())) {
            //Generamos el token
            String token = jwtUtil.generateToken(usuario.getEmail());

            //Devolvemos el token al cliente
            return ResponseEntity.ok().body(Map.of(
                    "status", "ok",
                    "token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }



}
