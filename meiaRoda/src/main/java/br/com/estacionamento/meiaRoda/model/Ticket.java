//package br.com.estacionamento.meiaRoda.model;
//
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.validation.constraints.NotBlank;
//
//public class Ticket {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	private LocalDateTime horaEntrada;
//
//	private LocalDateTime horaSaida;
//
//	private Double precoPorHora;
//	
//	private Integer numeroVaga;
//
//	@NotBlank
//	@OneToOne
//	@JoinColumn(name = "funcionario_id")
//	private Funcionario funcionario;
//
//	@NotBlank
//	@OneToOne
//	@JoinColumn(name = "cliente_id")
//	private Cliente cliente;
//
//	public Ticket() {
//
//	}
//
//	public Ticket(Long id, @NotBlank LocalDateTime horaEntrada, @NotBlank Double precoPorHora,
//			@NotBlank Integer numeroVaga) {
//		super();
//		this.id = id;
//		this.horaEntrada = LocalDateTime.now();
//		this.precoPorHora = precoPorHora;
//		this.numeroVaga = numeroVaga;
//	}
//
//	public LocalDateTime getHoraEntrada() {
//		return horaEntrada;
//	}
//
//	public void setHoraEntrada(LocalDateTime horaEntrada) {
//		this.horaEntrada = horaEntrada;
//	}
//
//	public LocalDateTime getHoraSaida() {
//		return horaSaida;
//	}
//
//	public void setHoraSaida(LocalDateTime horaSaida) {
//		this.horaSaida = horaSaida;
//	}
//
//	public Double getPrecoPorHora() {
//		return precoPorHora;
//	}
//
//	public void setPrecoPorHora(Double precoPorHora) {
//		this.precoPorHora = precoPorHora;
//	}
//
//	public Funcionario getFuncionario() {
//		return funcionario;
//	}
//
//	public void setFuncionario(Funcionario funcionario) {
//		this.funcionario = funcionario;
//	}
//
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
//
//	public Integer getNumeroVaga() {
//		return numeroVaga;
//	}
//
//	public void setNumeroVaga(Integer numeroVaga) {
//		this.numeroVaga = numeroVaga;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Ticket other = (Ticket) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
//
//	private Double precoTotal(Double tempoDePermanencia) {
//		return this.precoPorHora * tempoDePermanencia;
//	}
//
//	public Integer encerrarPermanencia(Vaga vaga) {
//		this.horaSaida = LocalDateTime.now();
//		Double tempoDePermanencia = null;
//		Double valorTotal = precoTotal(tempoDePermanencia);
//
//		long diff = ChronoUnit.SECONDS.between(horaEntrada, horaSaida);
//
//		return null;
//
//	}
//
//	public List<Vaga> verificarVagasLivres(List<Vaga> ocupadas) {
//		List<Vaga> vagasLivres = new ArrayList<Vaga>();
//
//		for (Vaga vaga : ocupadas) {
//			if (vaga.getStatus()) {
//				vagasLivres.add(vaga);
//			}
//		}
//		return vagasLivres;
//	}
//
//
//
//}
