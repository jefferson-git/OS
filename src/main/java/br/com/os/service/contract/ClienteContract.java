package br.com.os.service.contract;

import java.util.List;

import br.com.os.model.Cliente;
import br.com.os.model.dto.ClienteDto;

public interface ClienteContract {
	
	public Cliente findyById(Integer id);
	public List<Cliente> findyAll();
	public Cliente create(ClienteDto dto);
	public Cliente update(Integer id, ClienteDto dto);
	public void delete(Integer id);

}
