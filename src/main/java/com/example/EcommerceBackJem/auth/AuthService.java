package com.example.EcommerceBackJem.auth;

import com.example.EcommerceBackJem.auth.dto.AuthResponse;
import com.example.EcommerceBackJem.auth.dto.LoginRequest;
import com.example.EcommerceBackJem.auth.dto.RegisterRequest;
import com.example.EcommerceBackJem.config.AplicationConfig;
import com.example.EcommerceBackJem.entities.Usuario;
import com.example.EcommerceBackJem.entities.enums.Role;
import com.example.EcommerceBackJem.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        System.out.println("Username request: " + request.getEmail());
        UserDetails userDetails = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
        System.out.println("User name en auth service: " + userDetails.getUsername());
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
    public AuthResponse register(RegisterRequest request){
        Usuario usuario = Usuario.builder()
                .userName(request.getName() + " " + request.getLastname())
                .contraseña(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .phone(request.getPhone())
                .dni(request.getDNI())
                .rol(Role.USER)
                .build();
        usuarioRepository.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
