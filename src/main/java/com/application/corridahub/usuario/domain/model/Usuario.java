package com.application.corridahub.usuario.domain.model;

import java.time.LocalDateTime;

import com.application.corridahub.comum.domain.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data
public class Usuario implements BaseModel<Usuario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message = "Email inválido")
	private String email;
	
	private String senhaHash;

    private Boolean ativo;
    
    private LocalDateTime created;

	@Override
	public void update(Usuario source) {
		this.email = source.getEmail();
		this.senhaHash = source.getSenhaHash();
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public Usuario createNewInstance() {
		Usuario newInstance = new Usuario();
		newInstance.update(this);
		return newInstance;
	}

	@Override
	public void setCreated(LocalDateTime created) {
        this.created = created;
	}

	
	@PrePersist
    public void prePersist() {
        setCreated(LocalDateTime.now());
    }
}
