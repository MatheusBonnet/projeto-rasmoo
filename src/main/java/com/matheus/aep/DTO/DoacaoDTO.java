package com.matheus.aep.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class DoacaoDTO {
	
	private Long id;
	
	@NotBlank(message = "Informe a descricao da doacao!")
	@Min(value = 50, message = "Permitido no minimo 50 caracteres")
	@Max(value = 200, message = "Permitido no maximo 200 caracteres")
	private String descricao;

	@NotBlank(message = "Informe o telefone para contato!!")
	@Min(value = 11, message = "Permitido no minimo 20 numeros")
	@Max(value = 11, message = "Permitido no maximo 20 numeros")
	private Long telefone;
	
	@NotBlank(message = "Informe qual sera o tipo do produto!!")
	@Min(value = 5, message = "Permitido no minimo 5 caracteres")
	@Max(value = 50, message = "Permitido no maximo 50 caracteres")
	private String produto;
	
	@NotBlank(message = "Informe seu endereco!!")
	@Min(value = 5, message = "Permitido no minimo 5 caracteres")
	@Max(value = 100, message = "Permitido no maximo 100 caracteres")
	private String endereco;
	
	@NotBlank(message = "Informe o bairro em que voce mora!!")
	@Min(value = 5, message = "Permitido no minimo 5 caracteres")
	@Max(value = 100, message = "Permitido no maximo 100 caracteres")
	private String bairro;
	
	public DoacaoDTO() {

	}

	public DoacaoDTO(Long id, String descricao, Long telefone, String produto, String endereco, String bairro) {
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
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		DoacaoDTO other = (DoacaoDTO) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}


}
