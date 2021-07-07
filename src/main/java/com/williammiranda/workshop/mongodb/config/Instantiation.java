package com.williammiranda.workshop.mongodb.config;

import com.williammiranda.workshop.mongodb.domain.Post;
import com.williammiranda.workshop.mongodb.domain.User;
import com.williammiranda.workshop.mongodb.gateway.database.repository.PostRepository;
import com.williammiranda.workshop.mongodb.gateway.database.repository.UserRepository;
import com.williammiranda.workshop.mongodb.resources.domain.AuthorDTO;
import com.williammiranda.workshop.mongodb.resources.domain.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        var post1 = new Post(null,sdf.parse("21/03/2021"),"Partiu Viagem", "Estou viajando para São Paulo!", new AuthorDTO(maria), new ArrayList<>());
        var post2 = new Post(null,sdf.parse("23/03/2021"),"Bom Dia", "Acordei Feliz Hoje!", new AuthorDTO(maria), new ArrayList<>());

        var comment1 = new CommentDTO("Boa Viagem Mano!", sdf.parse("21/03/2021"), new AuthorDTO(alex));
        var comment2 = new CommentDTO("Aproveite", sdf.parse("22/03/2021"), new AuthorDTO(bob));
        var comment3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("23/03/2021"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
