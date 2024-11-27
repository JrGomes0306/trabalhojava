package br.grupointegrado.educacional.controller;

import br.grupointegrado.educacional.model.Curso;
import br.grupointegrado.educacional.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Curso findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));
    }

    @PostMapping
    public Curso save(@RequestBody Curso curso) {
        return repository.save(curso);
    }

    @PutMapping("/{id}")
    public Curso update(@PathVariable Integer id, @RequestBody Curso curso) {
        Curso existingCurso = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        existingCurso.setNome(curso.getNome());
        existingCurso.setCodigo(curso.getCodigo());
        existingCurso.setCargaHoraria(curso.getCargaHoraria());

        return repository.save(existingCurso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Curso curso = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        repository.delete(curso);
    }
}
