package com.example.projeto1.controller;

import com.example.projeto1.model.Curriculo;
import com.example.projeto1.repository.CurriculoRepository;
import com.example.projeto1.service.CurriculoService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController {
    @Autowired
    private CurriculoRepository repository;
    @Autowired
    private CurriculoService curriculoService;
    @GetMapping
    public List<Curriculo> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Curriculo criar(@RequestBody Curriculo curriculo) {
        return repository.save(curriculo);
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getCurriculo(@PathVariable String id) {
        try {
            // Chama o serviço para buscar o currículo
            Document curriculo = curriculoService.getCurriculoById(id);
            if (curriculo == null) {
                return ResponseEntity.status(404).body("Currículo não encontrado");
            }
            return ResponseEntity.ok(curriculo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
