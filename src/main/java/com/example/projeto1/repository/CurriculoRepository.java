package com.example.projeto1.repository;


import com.example.projeto1.model.Curriculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurriculoRepository extends MongoRepository<Curriculo, String> {
}
