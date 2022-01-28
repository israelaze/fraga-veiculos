package br.com.fragaveiculos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(length = 15, nullable = false, unique = true)
	private String codigo;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(nullable = false)
	private Integer anoModelo;

	@Column(nullable = false)
	private Double preco;

	@Column(length = 50, nullable = false)
	private String cor;

	@Column(nullable = false)
	private Double km;

	@Column(nullable = false)
	private Integer qtdePortas;

	@Column(length = 8, unique = true)
	private String placa;

	@Column(columnDefinition = "TEXT")
	private String descricao;
}
