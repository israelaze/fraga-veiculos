package br.com.fragaveiculos.dtos;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePostDTO {

	@NotNull(message = "Campo obrigatório!")
	private String nome;
	
	@NotNull(message = "Campo obrigatório!")
	private String cpf;
	
	private String email;
	
	@NotNull(message = "Campo obrigatório!")
	private String telefone;
	
	@NotNull(message = "Campo obrigatório!")
	private String rua;
	
	@NotNull(message = "Campo obrigatório!")
	private String numero;
	
	@NotNull(message = "Campo obrigatório!")
	private String bairro;
	
	@NotNull(message = "Campo obrigatório!")
	private String municipio;
	
	@NotNull(message = "Campo obrigatório!")
	private String estado;
	
	@NotNull(message = "Campo obrigatório!")
	private String cep; 
	
	
}
