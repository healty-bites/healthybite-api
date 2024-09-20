package com.healthybites.service.impl;

import com.healthybites.model.entity.Administrador;
import com.healthybites.repository.AdministradorRepository;
import com.healthybites.service.AdminAdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminAdministradorServiceImpl implements AdminAdministradorService {

    private final AdministradorRepository administradorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Administrador> getAll() {
        return administradorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Administrador> paginate(Pageable pageable) {
        return administradorRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Administrador create(Administrador contenido) {
        return administradorRepository.save(contenido);
    }

    @Transactional(readOnly = true)
    @Override
    public Administrador findById(Integer id) {
        return administradorRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
    }

    @Transactional
    @Override
    public Administrador update(Integer id, Administrador updateContenido) {
        Administrador administradorFromDb = findById(id);
        administradorFromDb.setContrasena(updateContenido.getContrasena());
        administradorFromDb.setNombre(updateContenido.getNombre());
        administradorFromDb.setEmail(updateContenido.getEmail());
        administradorFromDb.setContrasena(updateContenido.getContrasena());
        administradorFromDb.setPlanCreado(updateContenido.getPlanCreado());
        administradorFromDb.setContenido(updateContenido.getContenido());
        return administradorRepository.save(administradorFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Administrador administrador = findById(id);
        administradorRepository.delete(administrador);
    }
}
