package br.com.os.service.contract;

import java.util.List;

import br.com.os.model.Tecnico;
import br.com.os.model.dto.TecnicoDto;

public interface TecnicoContract {
	
	public Tecnico findyById(Integer id);
	public List<Tecnico> findyAll();
	public Tecnico create(TecnicoDto dto);
	public Tecnico update(Integer id, TecnicoDto dto);
	public void delete(Integer id);

}
