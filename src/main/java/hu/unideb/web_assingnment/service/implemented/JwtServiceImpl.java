package hu.unideb.web_assingnment.service.implemented;

import hu.unideb.web_assingnment.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {//UserDetails, Map<String, Object>
        Map<String, Object> extraClaims = new HashMap<>();//public/private claimek
        userDetails.getAuthorities().forEach(authority -> extraClaims.put(authority.getAuthority(), authority));

        return Jwts.builder().claims(extraClaims).subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+300000))
                .signWith(getKey())
                .compact();
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        /*final Claims claims = Jwts.parser().setSigningKey("secret")
                .build()
                .parseClaimsJws(token)
                .getPayload();*/

        //claims.getSubject() -- csak felhasználónév kinyerése
        final Claims claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claimsResolver.apply(claims);
    }

    private SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode("secret12345678345678r49845ru8i9zhui45rzt6ui");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
