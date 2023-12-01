package com.application.racinghub.user.domain.model;

import java.time.LocalDateTime;

import com.application.racinghub.common.domain.model.BaseModel;
import com.application.racinghub.user.domain.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) 
public class User extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message = "Email inválido")
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	@NotNull(message = "Senha inválida")
	private String passHash;

    private Boolean active;
    
    private LocalDateTime created;
    
    @Enumerated(EnumType.ORDINAL)
    private Role role;	
}
