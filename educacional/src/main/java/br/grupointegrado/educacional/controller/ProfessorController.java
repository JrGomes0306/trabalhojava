package br.grupointegrado.educacional.controller;

import br.grupointegrado.educacional.model.Professor;
import br.grupointegrado.educacional.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping
    public List<Professor> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Professor findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));
    }

    @PostMapping
    public Professor save(@RequestBody Professor professor) {
        return repository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor update(@PathVariable Integer id, @RequestBody Professor professor) {
        Professor existingProfessor = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));

        existingProfessor.setNome(professor.getNome());
        existingProfessor.setEmail(professor.getEmail());
        existingProfessor.setTelefone(professor.getTelefone());
        existingProfessor.setEspecialidade(professor.getEspecialidade());

        return repository.save(existingProfessor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));

        repository.delete(professor);
    }
}
