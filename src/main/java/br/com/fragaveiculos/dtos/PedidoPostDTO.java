package br.com.fragaveiculos.dtos;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoPostDTO {
	
	private Instant data;
	private Double total;	



}
