package com.banking.banking_server.Utilty;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.webauthn.authentication.WebAuthnAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader=request.getHeader("Authorization");
        String userName=null;
        String jwtToken=null;


        if(tokenHeader!=null &&  tokenHeader.startsWith("Bearer")){
            jwtToken=tokenHeader.substring(7);

            try {
                userName=jwtUtil.getUsernameFromToken(jwtToken);
            }
            catch (IllegalArgumentException e)
            {
                logger.info("illegal Arument occutred");
            }
            catch (ExpiredJwtException e){
                logger.info("Token is expired");
                 e.printStackTrace();
            }
            catch (Exception e)
            {
                logger.info("Exception Occured");
                e.printStackTrace();
            }
        }
        else {
        logger.info("Invalid Header");
        }

        if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
            boolean tokenValidation=jwtUtil.validateToken(jwtToken, userDetails);

            if (tokenValidation){
                UsernamePasswordAuthenticationToken userAuth= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                userAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(userAuth);

            }
            else {
                logger.info("The Token is not validated");
            }
        }

        filterChain.doFilter(request,response);

    }
}
