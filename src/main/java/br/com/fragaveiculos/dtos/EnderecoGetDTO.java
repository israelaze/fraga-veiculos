package br.com.fragaveiculos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoGetDTO {
	
	private Integer id;
	private String rua;
	private String numero;
	private String Bairro;
	private String Municipio;
	private String estados;
	private String Cep;

}
