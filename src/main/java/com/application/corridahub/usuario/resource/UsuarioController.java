package com.application.corridahub.usuario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.corridahub.comum.domain.BaseService;
import com.application.corridahub.comum.resource.BaseController;
import com.application.corridahub.usuario.domain.UsuarioService;
import com.application.corridahub.usuario.domain.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario> {

	@Autowired
	private UsuarioService service;

	@Override
	public BaseService<Usuario> getService() {
		return service;
	}

}
