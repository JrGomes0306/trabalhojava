package br.grupointegrado.educacional.controller;

import br.grupointegrado.educacional.model.Turma;
import br.grupointegrado.educacional.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public List<Turma> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Turma findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
    }

    @PostMapping
    public Turma save(@RequestBody Turma turma) {
        return repository.save(turma);
    }

    @PutMapping("/{id}")
    public Turma update(@PathVariable Integer id, @RequestBody Turma turma) {
        Turma existingTurma = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        existingTurma.setAno(turma.getAno());
        existingTurma.setSemestre(turma.getSemestre());
        existingTurma.setCurso(turma.getCurso());

        return repository.save(existingTurma);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Turma turma = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        repository.delete(turma);
    }
}
