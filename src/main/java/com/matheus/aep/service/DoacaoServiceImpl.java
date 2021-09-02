package com.matheus.aep.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.matheus.aep.DTO.DoacaoDTO;
import com.matheus.aep.entity.DoacaoEntity;
import com.matheus.aep.exception.DocaoException;
import com.matheus.aep.repository.IDoacaoRepository;

@Service
public class DoacaoServiceImpl implements IDoacaoService {

	@Autowired
	private IDoacaoRepository doacaoRepository;

	@Override
	public Boolean atualizar(DoacaoDTO doacaoDTO){
		try {

			Optional<DoacaoEntity> daocaoOptional = doacaoRepository.findById(doacaoDTO.getId());
			
			if(daocaoOptional.isPresent()) {
				
			ModelMapper mapper = new ModelMapper();
			DoacaoEntity doacaoDto = mapper.map(daocaoOptional.get(), DoacaoEntity.class);

			doacaoRepository.save(doacaoDto);

			throw new DocaoException("Id passado nao existe, tente novamente", HttpStatus.NOT_FOUND);
			}
			return false;
		} catch (DocaoException d) {
			throw d;
		}catch (Exception e) {
			throw new DocaoException("Erro interno no servidor, consulte o suporte!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Boolean deletar(Long id){
		try {
			buscaPorId(id);
			this.doacaoRepository.deleteById(id);
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<DoacaoEntity> listarTodas() {
		return doacaoRepository.findAll();
	}

	@Override
	public DoacaoEntity buscaPorId(Long id) {
		try {
		Optional<DoacaoEntity> doacao = doacaoRepository.findById(id);
			if(doacao.isPresent()) {
				return doacao.get();
			}			
			throw new DocaoException("Doacao nao encontrada, entre com uma existente!!!", HttpStatus.NOT_FOUND);
		}catch (DocaoException d) {
			throw d;
		}catch (Exception e) {
			throw new DocaoException("Erro interno no servidor, consulte o suporte!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Boolean inserirDoacao(DoacaoDTO doacaoDTO) {
		try {
			ModelMapper mapper = new ModelMapper();
			DoacaoEntity doacaoDto = mapper.map(doacaoDTO, DoacaoEntity.class);
			doacaoRepository.save(doacaoDto);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}