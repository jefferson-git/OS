package br.com.os.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum Status {
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERADO(2, "ENCERADO");
	
	private Integer cod;
	private String descricao;
	
	public static Status toEnum (Integer codigo) {
		if(codigo == null)
			return null;		
		for (Status s : Status.values()) 
			if(codigo.equals(s.getCod()))
				return s;			
		throw new IllegalArgumentException("Status, "+codigo+ " invalida!");		
	}
}
