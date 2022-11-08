package com.soulwave.soulwaveapp.dao;

import com.soulwave.soulwaveapp.models.Usuario;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales (Usuario usuario) {
        String query = "FROM Usuario WHERE nombreusr = :nombreusr AND contrasena = :contrasena";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("nombreusr" , usuario.getNombreusr())
                .setParameter("contrasena" , usuario.getContrasena())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }
            return lista.get(0);

    }
}
