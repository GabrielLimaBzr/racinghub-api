package com.application.corridahub.usuario.domain.model;

import java.time.LocalDateTime;

import com.application.corridahub.comum.domain.model.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) 
public class Usuario extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message = "Email inválido")
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String senhaHash;

    private Boolean ativo;
    
    private LocalDateTime created;

}
