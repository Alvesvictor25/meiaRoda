package br.com.estacionamento.meiaRoda.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.estacionamento.meiaRoda.model.Veiculo;
import br.com.estacionamento.meiaRoda.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	VeiculoService veiculoService;

	@PostMapping
	public ResponseEntity<Veiculo> save(@Valid @RequestBody Veiculo veiculo) {
		veiculo = veiculoService.save(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/placa/{placa}")
				.buildAndExpand(veiculo.getPlaca()).toUri();
		return ResponseEntity.created(uri).body(veiculo);
	}

	@GetMapping(path = "/list")
	public ResponseEntity<List<Veiculo>> getList() {
		List<Veiculo> findAll = veiculoService.findAll();
		return new ResponseEntity<List<Veiculo>>(findAll, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Veiculo> getVeiculoById(@PathVariable("id") long id,
			@AuthenticationPrincipal UserDetails useDetails) {
		System.out.println(useDetails);
		return ResponseEntity.ok(veiculoService.findById(id));
	}

	@GetMapping(path = "/placa/{placa}")
	public ResponseEntity<Veiculo> getVeiculoByPlaca(@PathVariable("placa") String placa) {
		return ResponseEntity.ok(veiculoService.findByPlaca(placa));
	}

	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		veiculoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
		veiculo = veiculoService.update(id, veiculo);
		return ResponseEntity.ok().body(veiculo);
	}

}
