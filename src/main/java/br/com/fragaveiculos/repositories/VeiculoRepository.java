package br.com.fragaveiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fragaveiculos.entities.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	
	Veiculo findByCodigo(String codigo);
	Veiculo findByPlaca(String placa);
	
}
