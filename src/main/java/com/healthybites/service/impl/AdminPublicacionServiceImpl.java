package com.healthybites.service.impl;

import com.healthybites.model.entity.Publicacion;
import com.healthybites.repository.PublicacionRepository;
import com.healthybites.service.AdminPublicacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminPublicacionServiceImpl implements AdminPublicacionService {

    private final PublicacionRepository publicacionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Publicacion> getAll() {
        return publicacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Publicacion> paginate(Pageable pageable) {
        return publicacionRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Publicacion create(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Publicacion findById(Integer id) {
        return publicacionRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Publicacion no encontrada"));
    }

    @Transactional
    @Override
    public Publicacion update(Integer id, Publicacion updateContenido) {
        Publicacion publicacionFromDb = findById(id);
        publicacionFromDb.setContenido(updateContenido.getContenido());
        publicacionFromDb.setGrupoInteres(updateContenido.getGrupoInteres());
        publicacionFromDb.setAutor(updateContenido.getAutor());
        publicacionFromDb.setComentarios(updateContenido.getComentarios());
        return publicacionRepository.save(publicacionFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Publicacion publicacion = findById(id);
        publicacionRepository.delete(publicacion);
    }
}
