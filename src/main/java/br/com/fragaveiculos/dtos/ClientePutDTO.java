package br.com.fragaveiculos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePutDTO {

	private Integer id;
	private String nome;
	private String email;
	private String telefone;
}
