package com.healthybites.api;

import com.healthybites.model.entity.Progreso;
import com.healthybites.service.AdminProgresoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/progreso")
public class AdminProgresoController {
    private final AdminProgresoService adminProgresoService;

    @GetMapping
    public ResponseEntity<List<Progreso>> getAllProgreso() {
        List<Progreso> progresos = adminProgresoService.getAll();
        return new ResponseEntity<List<Progreso>>(progresos, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Progreso>> paginateProgresos(
            @PageableDefault(size = 5, sort = "pesoObjetivo")Pageable pageable) {
        Page<Progreso> progresos = adminProgresoService.paginate(pageable);
        return new ResponseEntity<Page<Progreso>>(progresos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progreso> getProgresoById(@PathVariable("id") Integer id) {
        Progreso progreso = adminProgresoService.findById(id);
        return new ResponseEntity<Progreso>(progreso, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Progreso> createProgreso(@RequestBody Progreso progreso) {
        Progreso newProgreso = adminProgresoService.create(progreso);
        return new ResponseEntity<Progreso>(newProgreso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progreso> updateProgreso(@PathVariable("id") Integer id, @RequestBody Progreso progreso) {
        Progreso updateProgreso = adminProgresoService.update(id, progreso);
        return new ResponseEntity<Progreso>(updateProgreso, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Progreso> deleteProgreso(@PathVariable("id") Integer id) {
        adminProgresoService.delete(id);
        return new ResponseEntity<Progreso>(HttpStatus.NO_CONTENT);
    }
}