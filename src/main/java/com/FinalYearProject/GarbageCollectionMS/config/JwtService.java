package com.FinalYearProject.GarbageCollectionMS.config;

import com.FinalYearProject.GarbageCollectionMS.entity.users.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private  String secretLey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    @Value("${jwt.refresh-token.expiration}")
    private long jwtRefreshExpiration;


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public <T>T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public String generateToken(User user){
        return generateToken(new HashMap<>(),user);
    }
    public String generateToken(
            Map<String, Object> extractClaims,
            User user)
    {
        return buildToken(extractClaims,user,jwtExpiration);
    }

    public String generateRefreshToken(
            User user)
    {
        return buildToken(new HashMap<>(),user,jwtRefreshExpiration);
    }

    private String buildToken(
            Map<String,Object> extractClaims,
            User user,//changed to UserDetails to User
            long jwtExpiration
    ){
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(user.getUsername())
                .claim("role",user.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()))&&!isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }
    private Key getSignInKey(){
        byte[] keyBytes= Decoders.BASE64.decode(secretLey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
