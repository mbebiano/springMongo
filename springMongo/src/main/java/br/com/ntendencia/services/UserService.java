package br.com.ntendencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ntendencia.domain.User;
import br.com.ntendencia.repository.UserRepository;
import br.com.ntendencia.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// instaciação do repósitorio
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id){
		
		Optional<User> optUser = repo.findById(id);
		
		if (optUser == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		//obtençao da entidade user através do objeto optional para entity
		User user = optUser.get();
		return user;
	}
}
