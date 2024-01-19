
package com.application.racinghub.user.domain.model;

import java.time.LocalDateTime;

import com.application.racinghub.common.domain.model.BaseModel;
import com.application.racinghub.person.domain.model.Person;
import com.application.racinghub.user.domain.enums.Role;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotNull(message = "Senha inválida")
	private String passHash;

	@NotNull(message = "E-mail inválido")
	@Email
	@Column(nullable = false, unique = true)
	private String email;

    private Boolean active = false;

	@CreatedDate
    private LocalDateTime created;
    
    @Enumerated(EnumType.ORDINAL)
    private Role role;

	@OneToOne
	@NotNull(message = "Pessoa inválida")
	private Person person;
}
