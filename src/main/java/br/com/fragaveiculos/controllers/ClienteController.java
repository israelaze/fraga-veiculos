package br.com.fragaveiculos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fragaveiculos.dtos.ClienteGetDTO;
import br.com.fragaveiculos.dtos.ClientePostDTO;
import br.com.fragaveiculos.dtos.ClientePutDTO;
import br.com.fragaveiculos.exceptions.ServiceException;
import br.com.fragaveiculos.services.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrar(ClientePostDTO dto){
		
		try {
			
			String response = clienteService.cadastrar(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ClienteGetDTO>> buscarTodos(){
		
		try {
			
			List<ClienteGetDTO> listaDto = clienteService.buscarTodos();
			return ResponseEntity.ok(listaDto);
			
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/buscarId/{id}")
	public ResponseEntity<ClienteGetDTO> buscarId(@PathVariable Integer id){
		
		try {
			
			ClienteGetDTO dto = clienteService.buscarId(id);
			return ResponseEntity.ok(dto);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/buscarCpf/{cpf}")
	public ResponseEntity<ClienteGetDTO> buscarCpf(@PathVariable String cpf){
		
		try {
			
			ClienteGetDTO dto = clienteService.buscarCpf(cpf);
			return ResponseEntity.ok(dto);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PatchMapping("/atualizar")
	public ResponseEntity<String> atualizar(ClientePutDTO dto){
		
		try {
			
			String response = clienteService.atualizar(dto);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id){
		
		try {
			
			String response = clienteService.excluir(id);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
