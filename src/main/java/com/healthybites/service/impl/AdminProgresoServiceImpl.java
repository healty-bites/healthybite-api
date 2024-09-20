package com.healthybites.service.impl;

import com.healthybites.model.entity.Progreso;
import com.healthybites.repository.ProgresoRepository;
import com.healthybites.service.AdminProgresoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service

public class AdminProgresoServiceImpl implements AdminProgresoService {
    private final ProgresoRepository progresoRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Progreso> getAll() {
        return progresoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Progreso> paginate(Pageable pageable) {
        return progresoRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Progreso findById(Integer id) {
        return progresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Progreso no encontrado"));
    }

    @Transactional
    @Override
    public Progreso create(Progreso progreso){
        return progresoRepository.save(progreso);
    }

    @Transactional
    @Override
    public Progreso update(Integer id, Progreso updateProgreso) {
        Progreso progresoFromDb = findById(id);
        progresoFromDb.setPesoObjetivo(updateProgreso.getPesoObjetivo());
        progresoFromDb.setCliente(updateProgreso.getCliente());
        progresoFromDb.setRegistro(updateProgreso.getRegistro());
        return progresoRepository.save(progresoFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Progreso progreso = findById(id);
        progresoRepository.delete(progreso);
    }

}
