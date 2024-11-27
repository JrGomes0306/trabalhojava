package br.grupointegrado.educacional.controller;

import br.grupointegrado.educacional.model.Disciplina;
import br.grupointegrado.educacional.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @GetMapping
    public List<Disciplina> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Disciplina findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));
    }

    @PostMapping
    public Disciplina save(@RequestBody Disciplina disciplina) {
        return repository.save(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina update(@PathVariable Integer id, @RequestBody Disciplina disciplina) {
        Disciplina existingDisciplina = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));

        existingDisciplina.setNome(disciplina.getNome());
        existingDisciplina.setCodigo(disciplina.getCodigo());
        existingDisciplina.setCurso(disciplina.getCurso());
        existingDisciplina.setProfessor(disciplina.getProfessor());

        return repository.save(existingDisciplina);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));

        repository.delete(disciplina);
    }
}
