package com.soulwave.soulwaveapp.dao;

import com.soulwave.soulwaveapp.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
