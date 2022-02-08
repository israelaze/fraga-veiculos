package br.com.fragaveiculos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculos")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true, length = 15)
	private String codigo;

	@Column(nullable = false, length = 50)
	private String nome;

	@Column(nullable = false)
	private Integer anoModelo;

	@Column(nullable = false)
	private Double preco;

	@Column(nullable = false, length = 50)
	private String cor;

	@Column(nullable = false)
	private Double km;

	@Column(nullable = false)
	private Integer qtdePortas;

	@Column(nullable = false, unique = true, length = 8)
	private String placa;

	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "marca_id", nullable = false)
	private Marca marca;
}
