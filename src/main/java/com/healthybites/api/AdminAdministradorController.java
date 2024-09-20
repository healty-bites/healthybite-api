package com.healthybites.api;

import com.healthybites.model.entity.Administrador;
import com.healthybites.service.AdminAdministradorService;
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
@RequestMapping("/admin/administrador")
public class AdminAdministradorController {
    private final AdminAdministradorService adminAdministradorService;

    @GetMapping
    public ResponseEntity<List<Administrador>> getAllAdministrador() {
        List<Administrador> administradores = adminAdministradorService.getAll();
        return new ResponseEntity<List<Administrador>>(administradores, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Administrador>> paginateAdministradores(
            @PageableDefault(size = 5, sort = "nombre")Pageable pageable) {
        Page<Administrador> administradores = adminAdministradorService.paginate(pageable);
        return new ResponseEntity<Page<Administrador>>(administradores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable("id") Integer id) {
        Administrador administrador = adminAdministradorService.findById(id);
        return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Administrador> createAdministrador(@RequestBody Administrador administrador) {
        Administrador newAdministrador = adminAdministradorService.create(administrador);
        return new ResponseEntity<Administrador>(newAdministrador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> updateAdministrador(@PathVariable("id") Integer id, @RequestBody Administrador administrador) {
        Administrador updateAdministrador = adminAdministradorService.update(id, administrador);
        return new ResponseEntity<Administrador>(updateAdministrador, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Administrador> deleteAdministrador(@PathVariable("id") Integer id) {
        adminAdministradorService.delete(id);
        return new ResponseEntity<Administrador>(HttpStatus.NO_CONTENT);
    }
}
