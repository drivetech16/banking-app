package com.banking.banking_server.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JwtUtil {

    private  static  final long EXPIRATION_TIME=5*60*60;

    @Value("${jwt.secret}")
    private  String SECRETE_KEY;

    private String generateToken(Map<String, Object> claims, String Subject)
    {
       return Jwts.builder().setClaims(claims).
               setSubject(Subject).setIssuedAt(new Date(System.currentTimeMillis())
       ).setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME)).
               signWith(SignatureAlgorithm.ES256,SECRETE_KEY).
       compact();
    }

    public  String TokenGeneration(UserDetails userDetails)
    {
        Map<String, Object> claims=new HashMap<>();
        claims.put("userID", ((User)userDetails).getUserId());
        return  generateToken(claims, userDetails.getUsername());
    }

    public Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(SECRETE_KEY).parseClaimsJws(token).getBody();

    }
    public  <T> T getClaimFromToken(String token , Function<Claims, T> claimsresolver) {
       final  Claims claims=getAllClaimsFromToken(token);
       return  claimsresolver.apply(claims);
    }
    public  String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public  Date getExpirationDateFromToken(String token){
        return  getClaimFromToken(token , Claims::getExpiration);
    }








}
