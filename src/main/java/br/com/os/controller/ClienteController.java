package br.com.os.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import br.com.os.config.Mapper;
import br.com.os.model.dto.ClienteDto;
import br.com.os.service.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired ClienteService clienteService;
	@Autowired Mapper mapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> fyndById(@PathVariable Integer id){
		return ResponseEntity.ok().body(mapper.mapeando().map(clienteService.findyById(id), ClienteDto.class));
	}

	@GetMapping
	public ResponseEntity<List<ClienteDto>> finAll(){
		return ResponseEntity.ok().body(clienteService.findyAll()
				.stream().map(obj -> mapper.mapeando().map(obj, ClienteDto.class)).collect(Collectors.toList()));
	}
	
	@PostMapping()
    public ResponseEntity<UriComponents> create(@RequestBody @Valid ClienteDto dto){
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clienteService.create(dto).getId()).toUri()).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDto> update(@PathVariable Integer id, @RequestBody @Valid ClienteDto dto){
		return ResponseEntity.ok().body(mapper.mapeando().map(clienteService.update(id, dto), ClienteDto.class));		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

}