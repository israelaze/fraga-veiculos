package br.com.fragaveiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fragaveiculos.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	Cliente findByCpf(String cpf);
	Cliente findByTelefone(String telefone);
}
