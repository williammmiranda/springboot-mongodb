package com.williammiranda.workshop.mongodb.services;

import com.williammiranda.workshop.mongodb.domain.Post;
import com.williammiranda.workshop.mongodb.gateway.database.repository.PostRepository;
import com.williammiranda.workshop.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id){
        Optional<Post> Post = postRepository.findById(id);
        return Post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

}
