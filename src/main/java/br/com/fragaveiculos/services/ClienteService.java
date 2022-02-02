package br.com.fragaveiculos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fragaveiculos.dtos.ClienteGetDTO;
import br.com.fragaveiculos.dtos.ClientePostDTO;
import br.com.fragaveiculos.dtos.ClientePutDTO;
import br.com.fragaveiculos.entities.Cliente;
import br.com.fragaveiculos.exceptions.BadRequestException;
import br.com.fragaveiculos.exceptions.EntityNotFoundException;
import br.com.fragaveiculos.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	String response;
	
	public String cadastrar(ClientePostDTO dto) {
		
		Cliente result1 = clienteRepository.findByCpf(dto.getCpf());
		Cliente result2 = clienteRepository.findByTelefone(dto.getTelefone());
		
		if(result1 != null) {
			response = "O cpf " + dto.getCpf() + " já está cadastrado!";
			throw new BadRequestException(response);
			
		}else if(result2 != null){
			response = "O telefone " + dto.getTelefone() + " já está cadastrado!";
			throw new BadRequestException(response);

		}else {
			Cliente cliente = new Cliente();
			mapper.map(dto, cliente);
			clienteRepository.save(cliente);
			
			response = "Cliente cadastrado com sucesso!";
			return response;
		}
	}

	public List<ClienteGetDTO> buscarTodos(){
		
		List<Cliente> listaCliente = clienteRepository.findAll();
		
		List<ClienteGetDTO> listaDto = new ArrayList<ClienteGetDTO>();
		
		for(Cliente cliente : listaCliente) {
			
			ClienteGetDTO dto = new ClienteGetDTO();
			
			mapper.map(cliente, dto);
			
			listaDto.add(dto);
		}
		return listaDto;
	}
	
	public ClienteGetDTO buscarId(Integer id) {
		
		Optional<Cliente> result = clienteRepository.findById(id);
		
		if(result.isEmpty()) {
			response = "Cliente não encontrado! ID: " + id;
			throw new EntityNotFoundException(response);
			
		}else {
			Cliente cliente = result.get();
			
			ClienteGetDTO dto = new ClienteGetDTO();
			mapper.map(cliente, dto);
			
			return dto;
		}
	}
	
	public ClienteGetDTO buscarCpf(String cpf) {
		
		Cliente result = clienteRepository.findByCpf(cpf);
		
		if(result == null) {
			response = "Cliente não encontrado! CPF: " + cpf;
			throw new EntityNotFoundException(response);
			
		}else {

			ClienteGetDTO dto = new ClienteGetDTO();
			mapper.map(result, dto);
			
			return dto;
		}
	}
	
	public String atualizar(ClientePutDTO dto) {

		Optional<Cliente> result = clienteRepository.findById(dto.getId());

		if(result.isEmpty()) {
			response = "Cliente não encontrado!  ID: " + dto.getId();
			throw new EntityNotFoundException(response);
			
		}else {
			Cliente cliente = result.get();
			
			mapper.map(dto, cliente);
			clienteRepository.save(cliente);

			response = "Cliente atualizado com sucesso!";
			return response;
		}
	}

	public String excluir(Integer id) {

		Optional<Cliente> result = clienteRepository.findById(id);

		if(result.isEmpty()) {
			response = "Cliente não encontrado!  ID: " + id;
			throw new EntityNotFoundException(response);
			
		}else {
			Cliente cliente = result.get();
			clienteRepository.delete(cliente);

			String response = "Cliente excluído com sucesso!";
			return response;
		}	
	}

}
