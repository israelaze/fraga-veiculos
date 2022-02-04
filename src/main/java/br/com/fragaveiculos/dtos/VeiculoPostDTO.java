package br.com.fragaveiculos.dtos;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoPostDTO {

	@NotNull(message = "Campo obrigatório!")
	private String codigo;
	
	@NotNull(message = "Campo obrigatório!")
	private String nome;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer anoModelo;
	
	@NotNull(message = "Campo obrigatório!")
	private Double preco;
	
	@NotNull(message = "Campo obrigatório!")
	private String cor;
	
	@NotNull(message = "Campo obrigatório!")
	private Double km;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer qtdePortas;
	
	@NotNull(message = "Campo obrigatório!")
	private String placa;
	
	private String descricao;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer marca;

}
