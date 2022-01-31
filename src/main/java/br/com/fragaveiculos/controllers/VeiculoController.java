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

import br.com.fragaveiculos.dtos.VeiculoGetDTO;
import br.com.fragaveiculos.dtos.VeiculoPostDTO;
import br.com.fragaveiculos.dtos.VeiculoPutDTO;
import br.com.fragaveiculos.exceptions.ServiceException;
import br.com.fragaveiculos.services.VeiculoService;

@RestController
@RequestMapping("/api/v1/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrar(VeiculoPostDTO dto) {

		try {

			String response = veiculoService.cadastrar(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/lista")
	public ResponseEntity<List<VeiculoGetDTO>> buscarTodos() {

		try {

			List<VeiculoGetDTO> listaDto = veiculoService.buscarTodos();
			return ResponseEntity.ok(listaDto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/buscarId/{id}")
	public ResponseEntity<VeiculoGetDTO> buscarId(@PathVariable Integer id) {

		try {

			VeiculoGetDTO dto = veiculoService.buscarId(id);
			return ResponseEntity.ok(dto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/buscarCodigo/{codigo}")
	public ResponseEntity<VeiculoGetDTO> buscarCodigo(@PathVariable String codigo) {

		try {

			VeiculoGetDTO dto = veiculoService.buscarCodigo(codigo);
			return ResponseEntity.ok(dto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/buscarPlaca/{placa}")
	public ResponseEntity<VeiculoGetDTO> buscarPlaca(@PathVariable String placa) {

		try {

			VeiculoGetDTO dto = veiculoService.buscarPlaca(placa);
			return ResponseEntity.ok(dto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PatchMapping("/atualizar")
	public ResponseEntity<String> atualizar(VeiculoPutDTO dto){
		
		try {
			
			String response = veiculoService.atualizar(dto);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id){
		
		try {
			
			String response = veiculoService.excluir(id);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
