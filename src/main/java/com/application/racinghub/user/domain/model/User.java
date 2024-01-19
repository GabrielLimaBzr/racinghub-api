
package com.application.racinghub.user.domain.model;

import java.time.LocalDateTime;

import com.application.racinghub.common.domain.model.BaseModel;
import com.application.racinghub.person.domain.model.Person;
import com.application.racinghub.user.domain.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
	
	@OneToOne
	@NotNull(message = "Pessoa inválida")
	private Person person;
	
	@Column(nullable = false)
	@NotNull(message = "Senha inválida")
	private String passHash;

    private Boolean active = false;
    
    private LocalDateTime created;
    
    @Enumerated(EnumType.ORDINAL)
    private Role role;	
}
