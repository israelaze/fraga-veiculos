package br.com.fragaveiculos.dtos;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcaPutDTO {

	@NotNull
	private Integer id;
	
	@NotNull(message = "Campo obrigatório!")
	private String nome;
	
	@NotNull(message = "Campo obrigatório!")
	private String nacionalidade;
}
