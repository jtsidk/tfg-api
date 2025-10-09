package tfg.warhammerScanner.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final Key claveSecreta;
    private final long expiration;

    public JwtUtil (@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") long expiration) {
        this.claveSecreta = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expiration;
    }

    //Generamos el token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(claveSecreta, SignatureAlgorithm.HS256)
                .compact();
    }

    //Extraemos el username del token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //Ver si ha expirado
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //Validar token
    public boolean validateToken(String token, String username) {
        final String extractedUserName = extractUsername(token);
        return (extractedUserName.equals(username) && !isTokenExpired(token));
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder().setSigningKey(claveSecreta).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

}
