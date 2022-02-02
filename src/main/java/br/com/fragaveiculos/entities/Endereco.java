package br.com.fragaveiculos.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.fragaveiculos.entities.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String rua;
	
	@Column(length = 10, nullable = false)
	private String numero;
	
	@Column(length = 50, nullable = false)
	private String bairro;
	
	@Column(length = 100, nullable = false)
	private String municipio;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Estado estado;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@OneToMany(mappedBy = "endereco")
	private Set<Cliente> clientes = new HashSet<>();
	
}
