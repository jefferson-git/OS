package br.com.os.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial") 
@NoArgsConstructor
@Getter @Setter @Entity
public class Tecnico extends Pessoa implements Serializable{	
	
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<Os> lista = new ArrayList<>();
	
	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}
	
	
}
