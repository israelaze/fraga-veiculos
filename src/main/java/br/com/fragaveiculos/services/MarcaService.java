package br.com.fragaveiculos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.fragaveiculos.dtos.MarcaGetDTO;
import br.com.fragaveiculos.dtos.MarcaPostDTO;
import br.com.fragaveiculos.dtos.MarcaPutDTO;
import br.com.fragaveiculos.entities.Marca;
import br.com.fragaveiculos.exceptions.BadRequestException;
import br.com.fragaveiculos.exceptions.EntityNotFoundException;
import br.com.fragaveiculos.repositories.MarcaRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MarcaService {

	private final MarcaRepository marcaRepository;
	private final ModelMapper mapper;

	String badResponse = "Já cadastrada! ";
	String notFoundResponse = "Não encontrada! ";
	String sucessResponse = "Sucesso! ";

	public String cadastrar(MarcaPostDTO dto) {

	 	Marca result = marcaRepository.findByNome(dto.getNome());
		if (result != null) {
			throw new BadRequestException(badResponse + dto.getNome());
		
		}else {
			
			Marca marca = new Marca();
			mapper.map(dto, marca);
			
			marcaRepository.save(marca);
		
			return sucessResponse;
		}
	}

	public List<MarcaGetDTO> buscarTodas() {

		List<Marca> listaMarca = marcaRepository.findAll();

		List<MarcaGetDTO> listaDto = new ArrayList<MarcaGetDTO>();
		
		for (Marca marca : listaMarca) {
			MarcaGetDTO dto = new MarcaGetDTO();

			mapper.map(marca, dto);
			listaDto.add(dto);
		}
		return listaDto;
	}

	public MarcaGetDTO buscarId(Integer id) {

		Optional<Marca> result = marcaRepository.findById(id);

		if (result.isEmpty()) {
			throw new EntityNotFoundException(notFoundResponse + id);

		} else {
			Marca marca = result.get();
			MarcaGetDTO dto = new MarcaGetDTO();

			mapper.map(marca, dto);

			return dto;
		}
	}

	public MarcaGetDTO buscarNome(String nome) {

		Marca result = marcaRepository.findByNome(nome);

		if (result == null) {
			throw new EntityNotFoundException(notFoundResponse + nome);

		} else {
			MarcaGetDTO dto = new MarcaGetDTO();

			mapper.map(result, dto);

			return dto;
		}
	}

	public String atualizar(MarcaPutDTO dto) {

		Optional<Marca> result = marcaRepository.findById(dto.getId());

		if (result.isEmpty()) {
			throw new EntityNotFoundException(notFoundResponse + dto.getId());
			
		}else {
			Marca marca = result.get();
	
			mapper.map(dto, marca);
			marcaRepository.save(marca);

			return sucessResponse;
		}
	}

	public String excluir(Integer id) {

		Optional<Marca> result = marcaRepository.findById(id);

		if (result.isEmpty()) {
			throw new EntityNotFoundException(notFoundResponse + id);

		} else {
			Marca marca = result.get();
			marcaRepository.delete(marca);

			return sucessResponse;
		}
	}

}
