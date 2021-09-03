package com.matheus.aep.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.matheus.aep.DTO.DoacaoDTO;
import com.matheus.aep.entity.DoacaoEntity;
import com.matheus.aep.exception.DocaoException;
import com.matheus.aep.repository.IDoacaoRepository;

@CacheConfig(cacheNames = "OdoacaoDTO")
@Service
public class DoacaoServiceImpl implements IDoacaoService {

	public static final String MESSAGE_ERROR = "Erro interno no servidor, consulte o suporte!!!";
	
	public static final String MESSAGE_ERROR_DOACAO_NOT_FOUND = "Doacao nao encontrada, tente novamente.";
	
	@Autowired
	private IDoacaoRepository doacaoRepository;
	
	private ModelMapper mapper;
	
	@Autowired
	public DoacaoServiceImpl(IDoacaoRepository doacaoRepository) {
		this.mapper = new ModelMapper();
		this.doacaoRepository = doacaoRepository;
	}

	@CacheEvict( key = "#doacaoDTO.id")
	@Override
	public Boolean atualizar(DoacaoDTO doacaoDTO){
		try {

			Optional<DoacaoEntity> daocaoOptional = doacaoRepository.findById(doacaoDTO.getId());
			
			if(daocaoOptional.isPresent()) {
				
			DoacaoEntity doacaoDto = this.mapper.map(daocaoOptional.get(), DoacaoEntity.class);

			doacaoRepository.save(doacaoDto);

			throw new DocaoException(MESSAGE_ERROR_DOACAO_NOT_FOUND, HttpStatus.NOT_FOUND);
			}
			throw new DocaoException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (DocaoException d) {
			throw d;
		}catch (Exception e) {
			throw new DocaoException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Boolean deletar(Long id){
		try {
			buscaPorId(id);
			this.doacaoRepository.deleteById(id);
			return Boolean.TRUE;
			
		}catch (Exception e) {
			throw new DocaoException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CachePut(unless = "#result.size()<3")
	@Override
	public List<DoacaoEntity> listarTodas() {
		return doacaoRepository.findAll();
	}

	@Cacheable( key= "#id")
	@Override
	public DoacaoEntity buscaPorId(Long id) {
		try {
		Optional<DoacaoEntity> doacao = doacaoRepository.findById(id);
			if(doacao.isPresent()) {
				return doacao.get();
			}			
			throw new DocaoException(MESSAGE_ERROR_DOACAO_NOT_FOUND, HttpStatus.NOT_FOUND);
		}catch (DocaoException d) {
			throw d;
		}catch (Exception e) {
			throw new DocaoException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Boolean inserirDoacao(DoacaoDTO doacaoDTO) {
		try {
			DoacaoEntity doacaoDto = this.mapper.map(doacaoDTO, DoacaoEntity.class);
			doacaoRepository.save(doacaoDto);
			return Boolean.TRUE;
		}catch (Exception e) {
			throw new DocaoException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}