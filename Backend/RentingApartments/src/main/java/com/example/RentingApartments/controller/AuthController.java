package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.UserDTO;
import com.example.RentingApartments.model.User;
import com.example.RentingApartments.security.JWTResponse;
import com.example.RentingApartments.security.TokenUtils;
import com.example.RentingApartments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody UserDTO userDTO){
        String usernameLogged = userDTO.getUsername();
        User user = userService.findByUsername(usernameLogged);
        if(user != null) {//NE OVAKO
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            try {
                UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
                String token = tokenUtils.generateToken(userDetails);
                return ResponseEntity.ok(new JWTResponse(token,
                        userDetails.getUsername()));
            } catch (UsernameNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }else {//NE TREBA ELSE ()
            return ResponseEntity.status(404).build();
        }
    }

}
