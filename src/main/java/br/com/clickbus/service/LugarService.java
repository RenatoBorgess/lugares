package br.com.clickbus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.clickbus.controller.LugarResponse;
import br.com.clickbus.controller.LugarResquest;
import br.com.clickbus.model.Lugar;
import br.com.clickbus.repository.LugarRepository;

@Service
public class LugarService {

	@Autowired
	LugarRepository lugarRepository;

	public boolean delete(Long id) {
		Optional<Lugar> lugarOptional = lugarRepository.findById(id);
		boolean temLugar = lugarOptional.isPresent();
		if (temLugar) {
			Lugar lugar = lugarOptional.get();
			lugarRepository.delete(lugar);
			return true;
		} else
			return false;

	}

	public LugarResponse salvaLugar(LugarResquest lugarRequest) {
		boolean lugarCadastrado = lugarRepository.existsByNome(lugarRequest.getNome());
		if (lugarCadastrado == false) {
			Lugar lugar = new Lugar();
			lugar.setNome(lugarRequest.getNome());
			lugar.setCidade(lugarRequest.getCidade());
			lugar.setEstado(lugarRequest.getEstado());
			lugar.setSlug(lugarRequest.getNome().toLowerCase());
			
			Lugar lugarSalvo = lugarRepository.save(lugar);
			LugarResponse lugarResponse = new LugarResponse();
			lugarResponse.setCriadoEm(lugarSalvo.getCriadoEm());
			lugarResponse.setAtualizadoEm(lugarSalvo.getAtualizadoEm());
			lugarResponse.setSlug(lugarSalvo.getSlug());
			return lugarResponse;
		}
		return null; 
	}
}

