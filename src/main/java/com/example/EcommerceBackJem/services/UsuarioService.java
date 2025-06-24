package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Usuario;
import com.example.EcommerceBackJem.entities.dto.UpdateUserDTO;
import com.example.EcommerceBackJem.entities.dto.UsuarioDTO;
import com.example.EcommerceBackJem.entities.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.UsuarioRepository;

import java.util.ArrayList;

@Service
public class UsuarioService extends BaseService<Usuario, Long>{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioService(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }


    public Usuario modificarRol(Long idUser) throws Exception{
        Usuario usuario = usuarioRepository.findById(idUser).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (usuario.getRol().equals(Role.ADMIN)){
            usuario.setRol(Role.USER);
        } else {
            usuario.setRol(Role.ADMIN);
        }
        usuarioRepository.save(usuario);

        return usuario;
    }

    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        String contraseniaEncriptada = passwordEncoder.encode(usuarioDTO.getContrasenia());
        Usuario nuevoUsuario = Usuario.builder()
                .nombreCompleto(usuarioDTO.getNombreCompleto())
                .email(usuarioDTO.getEmail())
                .phone(usuarioDTO.getPhone())
                .rol(usuarioDTO.getRol())
                .dni(usuarioDTO.getDni())
                .contraseña(contraseniaEncriptada)
                .ordenesCompra(new ArrayList<>())
                .direcciones(new ArrayList<>())
                .build();
        usuarioRepository.save(nuevoUsuario);
        return nuevoUsuario;
    }

    public Usuario actualizarUsuario(Long idUser, UpdateUserDTO dto) throws Exception {
        Usuario usuario = usuarioRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setEmail(dto.getEmail());
        usuario.setRol(dto.getRol());
        usuario.setPhone(dto.getPhone());
        usuario.setDni(dto.getDni());

        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario cambiarContrasenia(String contrasenia, String nuevaContrasenia, Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(contrasenia, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String nuevaContraseniaEncriptada = passwordEncoder.encode(nuevaContrasenia);

        usuario.setContraseña(nuevaContraseniaEncriptada);

        usuarioRepository.save(usuario);

        return usuario;

    }

}
