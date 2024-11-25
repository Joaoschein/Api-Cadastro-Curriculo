package com.example.projeto1.service;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculoService {

    private MongoCollection<Document> collection;

    public void CurriculoService(MongoDatabase database) {
        this.collection = database.getCollection("curriculos");
    }

    public CurriculoService(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public Document getCurriculoById(String id) {
        try {
            // Converte o ID para ObjectId e faz a consulta
            Document query = new Document("_id", new ObjectId(id));
            return collection.find(query).first();
        } catch (IllegalArgumentException e) {
            // Captura erros, como um formato inválido de ID
            throw new RuntimeException("ID inválido: " + id, e);
        }
    }
}
