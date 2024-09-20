package com.healthybites.service.impl;

import com.healthybites.model.entity.Contenido;
import com.healthybites.repository.ContenidoRepository;
import com.healthybites.service.AdminContenidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminContenidoServiceImpl implements AdminContenidoService {

    private final ContenidoRepository contenidoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Contenido> getAll() {
        return contenidoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Contenido> paginate(Pageable pageable) {
        return contenidoRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Contenido create(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    @Transactional(readOnly = true)
    @Override
    public Contenido findById(Integer id) {
        return contenidoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
    }

    @Transactional
    @Override
    public Contenido update(Integer id, Contenido updateContenido) {
        Contenido contenidoFromDb = findById(id);
        contenidoFromDb.setTitulo(updateContenido.getTitulo());
        contenidoFromDb.setDescripcion(updateContenido.getDescripcion());
        contenidoFromDb.setTipoContenido(updateContenido.getTipoContenido());
        contenidoFromDb.setCategoria(updateContenido.getCategoria());
        return contenidoRepository.save(contenidoFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Contenido contenido = findById(id);
        contenidoRepository.delete(contenido);
    }
}
