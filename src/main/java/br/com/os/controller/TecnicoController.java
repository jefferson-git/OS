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
import br.com.os.model.dto.TecnicoDto;
import br.com.os.service.TecnicoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/tecnico")
public class TecnicoController {
	
	@Autowired TecnicoService tecnicoService;
	@Autowired Mapper mapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<TecnicoDto> fyndById(@PathVariable Integer id){
		return ResponseEntity.ok().body(mapper.mapeando().map(tecnicoService.findyById(id), TecnicoDto.class));
	}

	@GetMapping
	public ResponseEntity<List<TecnicoDto>> finAll(){
		return ResponseEntity.ok().body(tecnicoService.findyAll()
				.stream().map(obj -> mapper.mapeando().map(obj, TecnicoDto.class)).collect(Collectors.toList()));
	}
	
	@PostMapping()
    public ResponseEntity<UriComponents> create(@RequestBody @Valid TecnicoDto dto){
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tecnicoService.create(dto).getId()).toUri()).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TecnicoDto> update(@PathVariable Integer id, @RequestBody @Valid TecnicoDto dto){
		return ResponseEntity.ok().body(mapper.mapeando().map(tecnicoService.update(id, dto), TecnicoDto.class));		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		tecnicoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}