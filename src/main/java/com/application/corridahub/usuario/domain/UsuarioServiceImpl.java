package com.application.corridahub.usuario.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.application.corridahub.comum.domain.BaseServiceImpl;
import com.application.corridahub.usuario.domain.model.Usuario;
import com.application.corridahub.usuario.infra.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario> implements UsuarioService {

	public UsuarioServiceImpl() {
        super(Usuario.class);
    }
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	protected JpaRepository<Usuario, Long> getRepository() {
		return repository;
	}

}
