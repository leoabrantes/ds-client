package com.leoabrantes.dsclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoabrantes.dsclient.dto.ClientDTO;
import com.leoabrantes.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	
//	@PostMapping
//	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
//		dto = service.insert(dto);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(dto.getId()).toUri();		
//		return ResponseEntity.created(uri).body(dto);
//	}
//	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto){
//		dto = service.update(id, dto);
//		return ResponseEntity.ok().body(dto);
//	}
//	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<CategoryDTO> delete(@PathVariable Long id){
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}

}