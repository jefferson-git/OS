package br.com.os.service.contract;

import java.util.List;

import br.com.os.model.Os;
import br.com.os.model.dto.OsDto;

public interface OsContract {
	
	public Os findyById(Integer id);
	public List<Os> findyAll();
	public Os create(OsDto dto);
	public Os update(Integer id, OsDto dto);
	public void delete(Integer id);

}
