package com.williammiranda.workshop.mongodb.config;

import com.williammiranda.workshop.mongodb.domain.Post;
import com.williammiranda.workshop.mongodb.domain.User;
import com.williammiranda.workshop.mongodb.gateway.database.repository.PostRepository;
import com.williammiranda.workshop.mongodb.gateway.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
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

        var post1 = new Post(null,sdf.parse("21/03/2021"),"Partiu Viagem", "Estou viajando para São Paulo!", maria);
        var post2 = new Post(null,sdf.parse("23/03/2021"),"Bom Dia", "Acordei Feliz Hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
