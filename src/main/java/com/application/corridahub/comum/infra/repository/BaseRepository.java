package com.application.corridahub.comum.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.application.corridahub.comum.domain.model.BaseModel;

@NoRepositoryBean
public interface BaseRepository <T extends BaseModel<T>> extends JpaRepository<T, Long>{

}
