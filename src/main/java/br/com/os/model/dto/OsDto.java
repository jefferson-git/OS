package br.com.os.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@SuppressWarnings("serial")
public class OsDto implements Serializable{
	
	private Integer id;	
	private LocalDateTime dataAbertura = LocalDateTime.now();	
	private LocalDateTime dataEnceramento;
	private String observacao;
	private Integer prioridade;
	private Integer status;
	private Integer idTecnico;
	private Integer idCliente;		
}
