package br.com.os.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.os.config.Mapper;
import br.com.os.model.Pessoa;
import br.com.os.model.Cliente;
import br.com.os.model.dto.ClienteDto;
import br.com.os.repository.PessoaRepository;
import br.com.os.repository.ClienteRepository;
import br.com.os.service.contract.ClienteContract;
import br.com.os.service.exception.DataIntegrityViolationException;
import br.com.os.service.exception.ObjectNotFoundException;

@Service
public class ClienteService implements ClienteContract{
	
	@Autowired PessoaRepository pessoaRepository;	
	@Autowired ClienteRepository tecnicoRepository;	
	@Autowired Mapper mapper;

	@Override
	public Cliente findyById(Integer id) {
		return tecnicoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Cliente com id, "+id+" não encontrado"));
	}
	
	@Override
	public List<Cliente> findyAll(){
		return tecnicoRepository.findAll();
	}

	@Override
	public Cliente create(ClienteDto dto) {
		if(findyByCpf(dto) != null)
			throw new DataIntegrityViolationException("CPF já cadastrado!!");
		return tecnicoRepository.save(mapper.mapeando().map(dto, Cliente.class));
	}
	
	public Cliente update(Integer id, @Valid ClienteDto dto) {	
		dto.setId(id);	
		if(findyByCpf(dto) != null && findyById(dto.getId()).getId() != id)
			throw new DataIntegrityViolationException("CPF já cadastrado!!");			
	    return tecnicoRepository.save(mapper.mapeando().map(dto, findyById(id).getClass()));
	}
	
	@Override
	public void delete(Integer id) {
		if(findyById(id).getLista().size() > 0)
			throw new DataIntegrityViolationException("Cliente não pode ser deletado e ele possui Ordens de serviço vinculado a ele.");
		tecnicoRepository.deleteById(id);
	}
	
	private Pessoa findyByCpf(ClienteDto dto) {
		Pessoa result = pessoaRepository.findyByCpf(dto.getCpf());
		if(result != null)
			return result;
		return null;		 
	}
}
