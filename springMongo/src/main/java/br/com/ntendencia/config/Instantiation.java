package br.com.ntendencia.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.ntendencia.domain.Post;
import br.com.ntendencia.domain.User;
import br.com.ntendencia.dto.AuthorDTO;
import br.com.ntendencia.dto.CommentDTO;
import br.com.ntendencia.repository.PostRepository;
import br.com.ntendencia.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PostRepository postReposiroty;
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "BobGrey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2021") , "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));		
		Post post2 = new Post(null, sdf.parse("23/03/2021"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(alex));
		
		CommentDTO c1= new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		//salva os usuários para que adquiram id proprio userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postReposiroty.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
