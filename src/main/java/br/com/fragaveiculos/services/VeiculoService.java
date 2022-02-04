package br.com.fragaveiculos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.fragaveiculos.dtos.VeiculoGetDTO;
import br.com.fragaveiculos.dtos.VeiculoPostDTO;
import br.com.fragaveiculos.dtos.VeiculoPutDTO;
import br.com.fragaveiculos.entities.Marca;
import br.com.fragaveiculos.entities.Veiculo;
import br.com.fragaveiculos.exceptions.BadRequestException;
import br.com.fragaveiculos.exceptions.EntityNotFoundException;
import br.com.fragaveiculos.repositories.MarcaRepository;
import br.com.fragaveiculos.repositories.VeiculoRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VeiculoService {

	private final VeiculoRepository veiculoRepository;
	private final MarcaRepository marcaRepository;
	private final ModelMapper mapper;

	String badResponse = "Já cadastrado! ";
	String notFoundResponse = "Não encontrado! ";
	String sucessResponse = "Sucesso! ";
	String response;

	public String cadastrar(VeiculoPostDTO dto) {

		Veiculo v1 = veiculoRepository.findByCodigo(dto.getCodigo());
		Veiculo v2 = veiculoRepository.findByPlaca(dto.getPlaca());
		Optional<Marca> result = marcaRepository.findById(dto.getMarca());

		if (v1 != null || v2 != null) {
			throw new BadRequestException(badResponse);
			
		}else if (result.isEmpty()){
			response = "Marca não encontrada! ID: " + dto.getMarca();
			throw new EntityNotFoundException(response);
			
		} else {	
			Marca marca = result.get();
			Veiculo veiculo = new Veiculo();
			
			veiculo.setMarca(marca);
			mapper.map(dto, veiculo);
			
			veiculoRepository.save(veiculo);
			
			return sucessResponse;
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
			throw new EntityNotFoundException(notFoundResponse);

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
			throw new EntityNotFoundException(notFoundResponse + codigo);

		} else {
			VeiculoGetDTO dto = new VeiculoGetDTO();

			mapper.map(result, dto);

			return dto;
		}
	}
	
	public VeiculoGetDTO buscarPlaca(String placa) {

		Veiculo result = veiculoRepository.findByPlaca(placa);

		if (result == null) {
			throw new EntityNotFoundException(notFoundResponse + placa);

		} else {
			VeiculoGetDTO dto = new VeiculoGetDTO();

			mapper.map(result, dto);

			return dto;
		}
	}

	public String atualizar(VeiculoPutDTO dto) {

		Optional<Veiculo> result = veiculoRepository.findById(dto.getId());

		if(result.isEmpty()) {
			throw new EntityNotFoundException(notFoundResponse + dto.getId());
			
		}else {
			Veiculo veiculo = result.get();
			
			mapper.map(dto, veiculo);
			veiculoRepository.save(veiculo);

			return sucessResponse;
		}
	}

	public String excluir(Integer id) {

		Optional<Veiculo> result = veiculoRepository.findById(id);

		if(result.isEmpty()) {
			throw new EntityNotFoundException(notFoundResponse + id);
			
		}else {
			Veiculo veiculo = result.get();
			veiculoRepository.delete(veiculo);
			
			return sucessResponse;
		}	
	}

}
