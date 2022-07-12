package br.com.os.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum Prioridade {
	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTO(2, "ALTA");
	
	private Integer cod;
	private String descricao;
	
	public static Prioridade toEnum (Integer codigo) {
		if(codigo == null)
			return null;		
		for (Prioridade p : Prioridade.values()) 
			if(codigo.equals(p.getCod()))
				return p;			
		throw new IllegalArgumentException("Prioridade, "+codigo+ " invalida!");		
	}
}
