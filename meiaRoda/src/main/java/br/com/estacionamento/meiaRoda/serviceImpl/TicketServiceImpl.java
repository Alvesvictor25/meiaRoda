//package br.com.estacionamento.meiaRoda.serviceImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import br.com.estacionamento.meiaRoda.model.Ticket;
//import br.com.estacionamento.meiaRoda.model.Vaga;
//import br.com.estacionamento.meiaRoda.service.TicketService;
//import br.com.estacionamento.meiaRoda.service.VagaService;
//
//@Service
//public class TicketServiceImpl implements TicketService {
//
//	@Autowired
//	private TicketService ticketService;
//	@Autowired
//	private VagaService vagaService;
//
//	@Override
//	public Ticket save(Ticket ticket) {
//		ticketService.save(ticket);
//		return ticket;
//				
//	}
//
//	private Vaga vagaLivre() {
//		List<Vaga> findAll = vagaService.findAll();
//		Vaga livre = new Vaga();
//		for (Vaga vaga : findAll) {
//			if (!vaga.getStatus()) {
//				livre = vaga;
//				break;
//			}
//		}
//		return livre;
//	}
//
//	@Override
//	public List<Ticket> findAll() {
//		List<Ticket> listAll = ticketService.findAll();
//		return listAll;
//	}
//
//	@Override
//	public Ticket findById(long id) {
//		Ticket ticket = ticketService.findById(id);
//		return ticket;
//	}
//
//}
