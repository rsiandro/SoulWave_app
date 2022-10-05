package com.soulwave.soulwaveapp.controllers;

import com.soulwave.soulwaveapp.dao.UsuarioDao;
import com.soulwave.soulwaveapp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();

    }

}
