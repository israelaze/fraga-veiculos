package br.com.fragaveiculos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fragaveiculos.dtos.MarcaGetDTO;
import br.com.fragaveiculos.dtos.MarcaPostDTO;
import br.com.fragaveiculos.dtos.MarcaPutDTO;
import br.com.fragaveiculos.exceptions.ServiceException;
import br.com.fragaveiculos.services.MarcaService;

@RestController
@RequestMapping("/api/v1/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrar(MarcaPostDTO dto) {

		try {

			String response = marcaService.cadastrar(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/lista")
	public ResponseEntity<List<MarcaGetDTO>> buscarTodas() {

		try {

			List<MarcaGetDTO> listaDto = marcaService.buscarTodas();
			return ResponseEntity.ok(listaDto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/buscarId/{id}")
	public ResponseEntity<MarcaGetDTO> buscarId(@PathVariable Integer id) {

		try {

			MarcaGetDTO dto = marcaService.buscarId(id);
			return ResponseEntity.ok(dto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/buscarNome/{nome}")
	public ResponseEntity<MarcaGetDTO> buscarNome(@PathVariable String nome) {

		try {

			MarcaGetDTO dto = marcaService.buscarNome(nome);
			return ResponseEntity.ok(dto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizar(MarcaPutDTO dto){
		
		try {
			
			String response = marcaService.atualizar(dto);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id){
		
		try {
			
			String response = marcaService.excluir(id);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
