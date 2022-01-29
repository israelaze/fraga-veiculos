package br.com.fragaveiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fragaveiculos.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{
	
	Marca findByNome(String nome);
}
