package com.matheus.aep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.aep.entity.DoacaoEntity;

@Repository
public interface IDoacaoRepository extends JpaRepository<DoacaoEntity, Long>{

}
