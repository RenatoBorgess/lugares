package br.com.clickbus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickbus.model.Lugar;
import br.com.clickbus.repository.LugarRepository;
import br.com.clickbus.service.LugarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST de Lugares")
@CrossOrigin(origins = "*")
@RestController("/")
public class LugarController {

	@Autowired
	LugarRepository lugarRepository;
	@Autowired
	LugarService lugarService;
	

	@PostMapping(path = "/lugar", consumes = { "application/json" })
	public LugarResponse salvaLugar(@RequestBody LugarResquest lugarResquest) {
		LugarResponse lugarResponse = lugarService.salvaLugar(lugarResquest);
		return lugarResponse;
	}

	@ApiOperation(value = "Atualiza uma informação do Lugar e retorna com data de atualização")
	@PutMapping(value = "/lugar")
	public Lugar atualizaLugar(@RequestBody Lugar lugar) {
		Lugar atualizado = lugarRepository.saveAndFlush(lugar);
		return atualizado;
	}

	@ApiOperation(value = "Retorna um lugar pelo seu id com data de criação e atualização")
	@GetMapping(path = "/lugar/{id}")
	public Optional<Lugar> listaLugarUnico(@PathVariable Long id) {
		return lugarRepository.findById(id);
	}

	@ApiOperation(value = "Retorna todos os lugares adicionados com data de criação e atualização")
	@GetMapping(path = "/lugar/todos")
	public List<Lugar> listaLugares() {
		return lugarRepository.findAll();
	}
	
	@DeleteMapping(path = "/lugar/{id}")
	public ResponseEntity<String> deletaLugar(@PathVariable Long id) {
		boolean deletou = lugarService.delete(id);
		ResponseEntity<String> response;
		if (deletou) {
			response = ResponseEntity.ok("Deletado com sucesso");

		} else 
			
			response = ResponseEntity.unprocessableEntity().build();
		
		 return response;
	}
	
}
