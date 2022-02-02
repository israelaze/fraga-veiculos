package br.com.fragaveiculos.dtos;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoPutDTO {
	
	private Integer id;
	private Instant data;
	private Double total;	



}
