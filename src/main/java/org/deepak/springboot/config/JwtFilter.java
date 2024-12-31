package org.deepak.springboot.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.deepak.springboot.service.JWTService;
import org.deepak.springboot.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JWTService jwtService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
          String authHeader = request.getHeader("Authorization");
          String token = "";
          String username = "";
          if(authHeader !=null && authHeader.startsWith("Bearer ")){
              token = authHeader.substring(7);
              username = jwtService.extractUserName(token);
              UserDetails userDetails = applicationContext.getBean(MyUserDetailsService.class).loadUserByUsername(username);

              if(username!= null && SecurityContextHolder.getContext().getAuthentication()==null){
                  if(jwtService.validateToken(token, userDetails)){
                      UsernamePasswordAuthenticationToken authenticationToken =
                              new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                      authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                  }
              }
          }
          filterChain.doFilter(request,response);

    }
}
