package com.matheus.aep.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.aep.DTO.DoacaoDTO;
import com.matheus.aep.entity.DoacaoEntity;
import com.matheus.aep.service.IDoacaoService;


@RestController
@RequestMapping("/doacoes")
public class DoacaoController {
	
	@Autowired
	private IDoacaoService doacaoService;
	
	@GetMapping
	public ResponseEntity<List<DoacaoEntity>> listarDoacoes(){
		return ResponseEntity.status(HttpStatus.OK).body(doacaoService.listarTodas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DoacaoEntity> bucarDoacaoPorId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(doacaoService.buscaPorId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Boolean> atualizarDoacao(@Valid @RequestBody DoacaoDTO doacaoDTO){
		return ResponseEntity.status(HttpStatus.OK).body(doacaoService.atualizar(doacaoDTO));
	}
	
	@PostMapping
	public ResponseEntity<Boolean> inserirDoacao(@Valid @RequestBody DoacaoDTO doacaoDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(doacaoService.inserirDoacao(doacaoDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluirMateria(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(doacaoService.deletar(id));
	}

}
