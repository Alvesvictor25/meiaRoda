package br.com.estacionamento.meiaRoda.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.estacionamento.meiaRoda.model.Vaga;
import br.com.estacionamento.meiaRoda.service.VagaService;

@RestController
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	VagaService vagaService;

	@PostMapping
	public ResponseEntity<Vaga> save(@RequestBody Vaga vaga) {
		vaga = vagaService.save(vaga);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vaga.getId()).toUri();
		return ResponseEntity.created(uri).body(vaga);
	}

	@GetMapping(path = "/list")
	public ResponseEntity<List<Vaga>> findAll() {
		List<Vaga> listAll = vagaService.findAll();
		return ResponseEntity.ok().body(listAll);
	}


}
