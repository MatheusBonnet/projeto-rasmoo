package com.matheus.aep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tb_doacao")
public class DoacaoEntity implements Serializable{

	private static final long serialVersionUID = 1828294080635336238L;

	@JsonInclude(Include.NON_NULL)
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "descricao")
	private String descricao;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "telefone")
	private Long telefone;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "tipo_produto")
	private String produto;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "bairro")
	private String bairro;
	
	public DoacaoEntity() {
	}

	public DoacaoEntity(Long id, String descricao, Long telefone, String produto, String endereco, String bairro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.telefone = telefone;
		this.produto = produto;
		this.endereco = endereco;
		this.bairro = bairro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoacaoEntity other = (DoacaoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
