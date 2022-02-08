package br.com.fragaveiculos.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoPostDTO {

	@NotBlank(message = "Campo obrigatório!")
	private String codigo;
	
	@NotBlank(message = "Campo obrigatório!")
	private String nome;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer anoModelo;
	
	@NotNull(message = "Campo obrigatório!")
	private Double preco;
	
	@NotBlank(message = "Campo obrigatório!")
	private String cor;
	
	@NotNull(message = "Campo obrigatório!")
	private Double km;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer qtdePortas;
	
	@NotBlank(message = "Campo obrigatório!")
	private String placa;
	
	private String descricao;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer marca;

}
