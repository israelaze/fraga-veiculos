package br.com.fragaveiculos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fragaveiculos.dtos.MarcaGetDTO;
import br.com.fragaveiculos.dtos.MarcaPostDTO;
import br.com.fragaveiculos.dtos.MarcaPutDTO;
import br.com.fragaveiculos.entities.Marca;
import br.com.fragaveiculos.exceptions.BadRequestException;
import br.com.fragaveiculos.exceptions.EntityNotFoundException;
import br.com.fragaveiculos.repositories.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	@Autowired
	private ModelMapper mapper;

	String response;

	public String cadastrar(MarcaPostDTO dto) {

		Marca result = marcaRepository.findByNome(dto.getNome());

		if (result != null) {
			response = "A marca: " + dto.getNome() + " já está cadastrada!";
			throw new BadRequestException(response);

		} else {
			Marca marca = new Marca();
			mapper.map(dto, marca);
			marcaRepository.save(marca);

			response = "Marca cadastrada com sucesso!";
			return response;
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
			response = "Marca não encontrada! ID: " + id;
			throw new EntityNotFoundException(response);

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
			response = "Marca não encontrada! NOME: " + nome;
			throw new EntityNotFoundException(response);

		} else {
			MarcaGetDTO dto = new MarcaGetDTO();

			mapper.map(result, dto);

			return dto;
		}
	}

	public String atualizar(MarcaPutDTO dto) {

		Optional<Marca> result = marcaRepository.findById(dto.getId());

		if (result.isEmpty()) {
			response = "Marca não encontrada!  ID: " + dto.getId();
			throw new EntityNotFoundException(response);

		} else {
			Marca marca = result.get();

			mapper.map(dto, marca);
			marcaRepository.save(marca);

			response = "Marca atualizada com sucesso!";
			return response;
		}
	}

	public String excluir(Integer id) {

		Optional<Marca> result = marcaRepository.findById(id);

		if (result.isEmpty()) {
			response = "Marca não encontrada! ID: " + id;
			throw new EntityNotFoundException(response);

		} else {
			Marca marca = result.get();
			marcaRepository.delete(marca);

			String response = "Marca excluída com sucesso!";
			return response;
		}
	}

}
