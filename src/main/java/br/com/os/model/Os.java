package br.com.os.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.os.enuns.Prioridade;
import br.com.os.enuns.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor @Getter @Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Os {

	@EqualsAndHashCode.Include @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura = LocalDateTime.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataEnceramento;
	private String observacao;
	private Integer prioridade;
	private Integer status;
	
	@ManyToOne
	private Tecnico tecnico;
	@ManyToOne
	private Cliente cliente;
	
	public Os(Integer id, String observacao, Prioridade prioridade, Status status, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.observacao = observacao;
		this.prioridade = prioridade.getCod();
		this.status = status.getCod();
		this.tecnico = tecnico;
		this.cliente = cliente;
	}	
}
