package br.com.fragaveiculos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePostDTO {

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
}
