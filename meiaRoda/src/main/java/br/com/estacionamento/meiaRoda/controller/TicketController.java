//package br.com.estacionamento.meiaRoda.controller;
//
//import java.net.URI;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import br.com.estacionamento.meiaRoda.model.Ticket;
//import br.com.estacionamento.meiaRoda.service.TicketService;
//
//@ComponentScan
//@RestController
//@RequestMapping("/ticket")
//public class TicketController {
//
//	@Autowired
//	TicketService ticketService;
//
//	@PostMapping
//	public ResponseEntity<Ticket> save(@RequestBody Ticket ticket) {
//		ticket = ticketService.save(ticket);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand("/{id}").toUri();
//		return ResponseEntity.created(uri).body(ticket);
//	}
//
//	@GetMapping
//	public ResponseEntity<List<Ticket>> getList() {
//		List<Ticket> listAll = ticketService.findAll();
//		return new ResponseEntity<List<Ticket>>(listAll, HttpStatus.OK);
//	}
//
//	@GetMapping(path = "/{id}")
//	public ResponseEntity<Ticket> getById(@PathVariable("id") long id) {
//		return new ResponseEntity<>(ticketService.findById(id), HttpStatus.OK);
//
//	}
//}
