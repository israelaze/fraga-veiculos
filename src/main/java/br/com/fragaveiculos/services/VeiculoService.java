package br.com.fragaveiculos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fragaveiculos.dtos.VeiculoGetDTO;
import br.com.fragaveiculos.dtos.VeiculoPostDTO;
import br.com.fragaveiculos.dtos.VeiculoPutDTO;
import br.com.fragaveiculos.entities.Veiculo;
import br.com.fragaveiculos.exceptions.BadRequestException;
import br.com.fragaveiculos.exceptions.EntityNotFoundException;
import br.com.fragaveiculos.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ModelMapper mapper;

	String response;

	public String cadastrar(VeiculoPostDTO dto) {

		Veiculo v1 = veiculoRepository.findByCodigo(dto.getCodigo());
		Veiculo v2 = veiculoRepository.findByPlaca(dto.getPlaca());

		if (v1 != null) {
			response = "O código: " + dto.getCodigo() + " já está cadastrado!";
			throw new BadRequestException(response);

		} else if (v2 != null) {
			response = "A placa: " + dto.getPlaca() + " já está cadastrada!";
			throw new BadRequestException(response);

		} else {
			Veiculo veiculo = new Veiculo();
			mapper.map(dto, veiculo);
			veiculoRepository.save(veiculo);

			response = "Veículo cadastrado com sucesso!";
			return response;
		}
	}

	public List<VeiculoGetDTO> buscarTodos() {

		List<Veiculo> listaVeiculo = veiculoRepository.findAll();

		List<VeiculoGetDTO> listaDto = new ArrayList<VeiculoGetDTO>();
		for (Veiculo veiculo : listaVeiculo) {
			VeiculoGetDTO dto = new VeiculoGetDTO();

			mapper.map(veiculo, dto);
			listaDto.add(dto);
		}
		return listaDto;
	}

	public VeiculoGetDTO buscarId(Integer id) {

		Optional<Veiculo> result = veiculoRepository.findById(id);

		if (result.isEmpty()) {
			response = "Veículo não encontrado!  ID: " + id;
			throw new EntityNotFoundException(response);

		} else {
			Veiculo veiculo = result.get();
			VeiculoGetDTO dto = new VeiculoGetDTO();

			mapper.map(veiculo, dto);

			return dto;
		}
	}

	public VeiculoGetDTO buscarCodigo(String codigo) {

		Veiculo result = veiculoRepository.findByCodigo(codigo);

		if (result == null) {
			response = "Veículo não encontrado!  CÓD: " + codigo;
			throw new EntityNotFoundException(response);

		} else {
			VeiculoGetDTO dto = new VeiculoGetDTO();

			mapper.map(result, dto);

			return dto;
		}
	}
	
	public VeiculoGetDTO buscarPlaca(String placa) {

		Veiculo result = veiculoRepository.findByCodigo(placa);

		if (result == null) {
			response = "Veículo não encontrado!  PLACA: " + placa;
			throw new EntityNotFoundException(response);

		} else {
			VeiculoGetDTO dto = new VeiculoGetDTO();

			mapper.map(result, dto);

			return dto;
		}
	}

	public String atualizar(VeiculoPutDTO dto) {

		Optional<Veiculo> result = veiculoRepository.findById(dto.getId());

		if(result.isEmpty()) {
			response = "Veículo não encontrado!  ID: " + dto.getId();
			throw new EntityNotFoundException(response);
			
		}else {
			Veiculo veiculo = result.get();
			
			mapper.map(dto, veiculo);
			veiculoRepository.save(veiculo);

			response = "Veículo atualizado com sucesso!";
			return response;
		}
	}

	public String excluir(Integer id) {

		Optional<Veiculo> result = veiculoRepository.findById(id);

		if(result.isEmpty()) {
			response = "Veículo não encontrado!  ID: " + id;
			throw new EntityNotFoundException(response);
			
		}else {
			Veiculo veiculo = result.get();
			veiculoRepository.delete(veiculo);

			String response = "Veículo excluído com sucesso!";
			return response;
		}	
	}

}
