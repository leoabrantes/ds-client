package com.leoabrantes.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leoabrantes.dsclient.entities.Client;

	@Repository
	public interface ClientRepository extends JpaRepository<Client, Long>{

	}
