package com.leoabrantes.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leoabrantes.dsclient.dto.ClientDTO;
import com.leoabrantes.dsclient.entities.Client;
import com.leoabrantes.dsclient.repositories.ClientRepository;
import com.leoabrantes.dsclient.services.exceptions.EntityNotFoundException;


@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity = repository.save(entity);
		return new ClientDTO(entity);

	}

//	@Transactional
//	public CategoryDTO update(Long id, CategoryDTO dto) {
//		try {
//			Category entity = repository.getOne(id);
//			entity.setName(dto.getName());
//			entity = repository.save(entity);
//			return new CategoryDTO(entity);
//		}
//		catch(EntityNotFoundException e){
//			throw new ResourceNotFoundException("Id not found" + id);
//		}
//	}
//
//	public void delete(Long id) {
//		try {
//		repository.deleteById(id);
//		}
//		catch(EmptyResultDataAccessException e) {
//			throw new ResourceNotFoundException("Id not found" + id);
//		}
//		catch(DataIntegrityViolationException e) {
//			throw new DatabaseException("Integrity violation");
//		}
//	}
}
