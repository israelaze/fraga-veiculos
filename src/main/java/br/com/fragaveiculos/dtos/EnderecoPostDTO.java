package br.com.fragaveiculos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoPostDTO {
	
	private String rua;
	private String numero;
	private String Bairro;
	private String Municipio;
	private String estado;
	private String Cep;

}
