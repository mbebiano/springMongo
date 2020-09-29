package br.com.ntendencia.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ntendencia.domain.Post;
import br.com.ntendencia.repository.PostRepository;
import br.com.ntendencia.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	// instaciação do repósitorio
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id){
		
		Optional<Post> optPost = repo.findById(id);
		
		
		if (optPost.isEmpty()) {
			System.out.println("Entrou");
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		else {
			System.out.println("N entrou");
			System.out.println(optPost);
		}
		//obtençao da entidade user através do objeto optional para entity
		Post post = optPost.get();
		return post;
		
		/*Optional<User> obj= repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));*/
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime()+24*60*60*1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
