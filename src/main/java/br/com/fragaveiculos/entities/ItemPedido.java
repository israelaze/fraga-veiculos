package br.com.fragaveiculos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fragaveiculos.entities.auxiliary.PedidoAuxiliar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itens")
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoAuxiliar id = new PedidoAuxiliar();
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private Double subTotal;
	
	public void setVeiculo(Veiculo veiculo) {
		id.setVeiculo(veiculo);
	}
	
	public void setCliente(Cliente cliente) {
		id.setCliente(cliente);
		
	}

}
