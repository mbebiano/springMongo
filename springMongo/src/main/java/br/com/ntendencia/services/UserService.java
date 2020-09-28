package br.com.ntendencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ntendencia.domain.User;
import br.com.ntendencia.dto.UserDTO;
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
		
		
		if (optUser.isEmpty()) {
			System.out.println("Entrou");
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		else {
			System.out.println("N entrou");
			System.out.println(optUser);
		}
		//obtençao da entidade user através do objeto optional para entity
		User user = optUser.get();
		return user;
		
		/*Optional<User> obj= repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));*/
	}
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id){	
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj= findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}
