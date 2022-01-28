package br.com.fragaveiculos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoPutDTO {

	private String nome;
	private Integer anoModelo;
	private Double preco;
	private String cor;
	private String descricao;

}
