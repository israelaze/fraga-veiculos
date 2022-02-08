package br.com.fragaveiculos.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcaPostDTO {
	
	@NotBlank(message = "Campo obrigatório!")
	private String nome;
	
	@NotBlank(message = "Campo obrigatório!")
	private String nacionalidade;
	
}
