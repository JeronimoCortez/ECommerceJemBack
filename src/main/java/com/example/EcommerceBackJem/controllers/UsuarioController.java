package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Usuario;
import com.example.EcommerceBackJem.entities.dto.PasswordChangeDto;
import com.example.EcommerceBackJem.entities.dto.UpdateUserDTO;
import com.example.EcommerceBackJem.entities.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseController<Usuario, Long>{
    public UsuarioController(BaseService<Usuario, Long> service) {
        super(service);
    }
    @Autowired
    private UsuarioService usuarioService;

    @PatchMapping("/modificarRol/{idUser}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable Long idUser) throws Exception {
        Usuario usuario = usuarioService.modificarRol(idUser);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/update/{idUser}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long idUser, @RequestBody UpdateUserDTO usuarioDTO) throws Exception {
        Usuario usuario = usuarioService.actualizarUsuario(idUser, usuarioDTO);
        return ResponseEntity.ok(usuario);
    }

    @PatchMapping("/update/{idUser}/password")
    public ResponseEntity<Usuario> cambiarContraseña(@PathVariable Long idUser, @RequestBody PasswordChangeDto dto) throws Exception {
        Usuario usuario = usuarioService.cambiarContrasenia(dto.getContrasenia(), dto.getNuevaContrasenia(), idUser);
        return ResponseEntity.ok(usuario);
    }
}


