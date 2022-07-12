package br.com.os.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial") @Entity
@NoArgsConstructor @Getter @Setter
public class Cliente extends Pessoa implements Serializable{
	
	@OneToMany(mappedBy = "cliente")
	private List<Os> lista = new ArrayList<>();

	public Cliente(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}		
}
