package br.com.ntendencia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ntendencia.domain.Post;

//Faz a conexão com o banco de Dados

@Repository
public interface PostRepository extends MongoRepository<Post, String>  {

}
