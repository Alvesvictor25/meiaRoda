
package br.com.estacionamento.meiaRoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.meiaRoda.model.Estacionamento;
import br.com.estacionamento.meiaRoda.serviceImpl.EstacionamentoService;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoService service;

	@RequestMapping("/save")
	@PutMapping
	public ResponseEntity<Estacionamento> save(@RequestBody Estacionamento estacionamento) {
		return ResponseEntity.ok().body(service.save(estacionamento));
	}
}
