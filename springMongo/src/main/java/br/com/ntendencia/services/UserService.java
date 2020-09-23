package br.com.ntendencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ntendencia.domain.User;
import br.com.ntendencia.repository.UserRepository;

@Service
public class UserService {

	// instaciação do repósitorio
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
