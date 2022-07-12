package br.com.os.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.os.config.Mapper;
import br.com.os.model.Pessoa;
import br.com.os.model.Tecnico;
import br.com.os.model.dto.TecnicoDto;
import br.com.os.repository.PessoaRepository;
import br.com.os.repository.TecnicoRepository;
import br.com.os.service.contract.TecnicoContract;
import br.com.os.service.exception.DataIntegrityViolationException;
import br.com.os.service.exception.ObjectNotFoundException;

@Service
public class TecnicoService implements TecnicoContract{
	
	@Autowired PessoaRepository pessoaRepository;	
	@Autowired TecnicoRepository tecnicoRepository;	
	@Autowired Mapper mapper;

	@Override
	public Tecnico findyById(Integer id) {
		return tecnicoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Tencnico com id, "+id+" não encontrado"));
	}
	
	@Override
	public List<Tecnico> findyAll(){
		return tecnicoRepository.findAll();
	}

	@Override
	public Tecnico create(TecnicoDto dto) {
		if(findyByCpf(dto) != null)
			throw new DataIntegrityViolationException("CPF já cadastrado!!");
		return tecnicoRepository.save(mapper.mapeando().map(dto, Tecnico.class));
	}
	
	public Tecnico update(Integer id, @Valid TecnicoDto dto) {	
		dto.setId(id);	
		if(findyByCpf(dto) != null && findyById(dto.getId()).getId() != id)
			throw new DataIntegrityViolationException("CPF já cadastrado!!");			
	    return tecnicoRepository.save(mapper.mapeando().map(dto, findyById(id).getClass()));
	}
	
	@Override
	public void delete(Integer id) {
		if(findyById(id).getLista().size() > 0)
			throw new DataIntegrityViolationException("técnico não pode ser deletado e ele possui Ordens de serviço vinculado a ele.");
		tecnicoRepository.deleteById(id);
	}
	
	private Pessoa findyByCpf(TecnicoDto dto) {
		Pessoa result = pessoaRepository.findyByCpf(dto.getCpf());
		if(result != null)
			return result;
		return null;		 
	}
}
