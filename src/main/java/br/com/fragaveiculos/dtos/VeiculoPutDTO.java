package br.com.fragaveiculos.dtos;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoPutDTO {

	@NotNull
	private Integer id;
	
	@NotNull(message = "Campo obrigatório!")
	private String nome;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer anoModelo;
	
	@NotNull(message = "Campo obrigatório!")
	private Double preco;
	
	@NotNull(message = "Campo obrigatório!")
	private String cor;
	
	private String descricao;

}
