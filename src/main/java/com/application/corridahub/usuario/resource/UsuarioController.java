package com.application.corridahub.usuario.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.corridahub.comum.resource.BaseController;
import com.application.corridahub.usuario.domain.UsuarioService;
import com.application.corridahub.usuario.domain.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario> {
	
	protected UsuarioController(final UsuarioService service) {
		super(service);
	}
	
}
