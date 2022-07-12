package br.com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.os.config.Mapper;
import br.com.os.model.Os;
import br.com.os.model.dto.OsDto;
import br.com.os.repository.OsRepository;
import br.com.os.service.contract.OsContract;
import br.com.os.service.exception.ObjectNotFoundException;

@Service
public class OsService implements OsContract{
	@Autowired OsRepository osRepository;
	@Autowired Mapper mapper;
	
	
	@Override
	public Os findyById(Integer id) {
		return osRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Ordem de serviço com o id, "+id+" não encontrado"));
	}

	@Override
	public List<Os> findyAll() {
		return osRepository.findAll();
	}

	@Override
	public Os create(OsDto dto) {
		return osRepository.save(mapper.mapeando().map(dto, Os.class));
	}

	@Override
	public Os update(Integer id, OsDto dto) {
		findyById(id);
		dto.setId(id);
		return osRepository.save(mapper.mapeando().map(dto, Os.class));
	}

	@Override
	public void delete(Integer id) {
		osRepository.deleteById(findyById(id).getId());		
	}

}
