package br.com.os.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@SuppressWarnings("serial")
public class ClienteDto implements Serializable{

	private Integer id;	
	@NotEmpty(message = "Campo NOME é obrigatório")
	private String nome;	
	@CPF @NotEmpty(message = "Campo CPF é obrigatório")
	@Column(unique=true)
	private String cpf;
	@NotEmpty(message = "Campo TELEFONE é obrigatório")
	private String telefone;
}
