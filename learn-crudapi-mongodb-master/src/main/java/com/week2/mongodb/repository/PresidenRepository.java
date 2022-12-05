package com.week2.mongodb.repository;

import com.week2.mongodb.model.Presiden;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PresidenRepository extends MongoRepository<Presiden, Long> {
}
