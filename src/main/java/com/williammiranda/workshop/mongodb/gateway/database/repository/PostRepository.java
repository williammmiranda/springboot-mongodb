package com.williammiranda.workshop.mongodb.gateway.database.repository;

import com.williammiranda.workshop.mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface PostRepository extends MongoRepository<Post, String> {
}
