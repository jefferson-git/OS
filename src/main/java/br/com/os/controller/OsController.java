package br.com.os.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import br.com.os.model.dto.OsDto;
import br.com.os.service.OsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/os") 
public class OsController {
	@Autowired OsService osService;
	@Autowired Mapper mapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<OsDto> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(mapper.mapeando().map( osService.findyById(id), OsDto.class));
	}
	
	@GetMapping
	public ResponseEntity<List<OsDto>> findAll(){
		return ResponseEntity.ok().body(osService.findyAll().stream().map(obj -> mapper.mapeando()
				.map(obj, OsDto.class)).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<UriComponents> create(@RequestBody OsDto dto){
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(mapper.mapeando().map(osService.create(dto), dto.getClass()).getId()).toUri()).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OsDto> update(@PathVariable Integer id, @RequestBody OsDto dto){
		return ResponseEntity.ok().body(mapper.mapeando().map( osService.update(id, dto), OsDto.class));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		osService.delete(id);
		return ResponseEntity.noContent().build();
	}
 
}
