<<<<<<<< HEAD:src/main/java/com/application/corridahub/user/domain/model/User.java
package com.application.corridahub.user.domain.model;
========
package com.application.racinghub.user.domain.model;
>>>>>>>> 0770783712ca578dd536507926601a963d4ef835:src/main/java/com/application/racinghub/user/domain/model/User.java

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
<<<<<<<< HEAD:src/main/java/com/application/corridahub/user/domain/model/User.java
========
	@NotNull(message = "Senha inválida")
>>>>>>>> 0770783712ca578dd536507926601a963d4ef835:src/main/java/com/application/racinghub/user/domain/model/User.java
	private String passHash;

    private Boolean active;
    
    private LocalDateTime created;
    
    @Enumerated(EnumType.ORDINAL)
    private Role role;	
}
