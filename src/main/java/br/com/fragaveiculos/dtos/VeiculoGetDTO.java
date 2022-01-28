package br.com.fragaveiculos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoGetDTO {

	private Integer id;
	private String codigo;
	private String nome;
	private Integer anoModelo;
	private Double preco;
	private String cor;
	private Double km;
	private Integer qtdePortas;
	private String placa;
	private String descricao;

	
}
