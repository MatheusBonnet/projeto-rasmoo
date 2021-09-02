package com.matheus.aep.service;

import java.util.List;

import com.matheus.aep.DTO.DoacaoDTO;
import com.matheus.aep.entity.DoacaoEntity;

public interface IDoacaoService {

	public Boolean atualizar(final DoacaoDTO doacaoDTO);
	
	public Boolean deletar(final Long id);
	
	public List<DoacaoEntity> listarTodas();
	
	public DoacaoEntity buscaPorId(final Long id);
	
	public Boolean inserirDoacao(final DoacaoDTO doacaoDTO);
}
