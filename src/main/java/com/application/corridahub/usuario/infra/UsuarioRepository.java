package com.application.corridahub.usuario.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.corridahub.usuario.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
