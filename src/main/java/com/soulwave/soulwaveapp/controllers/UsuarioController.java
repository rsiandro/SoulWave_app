package com.soulwave.soulwaveapp.controllers;

import com.soulwave.soulwaveapp.dao.UsuarioDao;
import com.soulwave.soulwaveapp.models.Usuario;
import com.soulwave.soulwaveapp.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value = "Autorization") String token) {

        String usuarioId = jwtUtil.getKey(token);
        if (usuarioId == null) {
            return new ArrayList<>();
        }
            return usuarioDao.getUsuarios();
    }
}
