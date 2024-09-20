package com.healthybites.service.impl;

import com.healthybites.model.entity.Comentario;
import com.healthybites.repository.ComentarioRepository;
import com.healthybites.service.AdminComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminComentarioServicelmpl implements AdminComentarioService {
    private final ComentarioRepository comentarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Comentario> getAll() {
        return comentarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Comentario> paginate(Pageable pageable) {
        return comentarioRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Comentario findById(Integer id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
    }

    @Transactional
    @Override
    public Comentario create(Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    @Transactional
    @Override
    public Comentario update(Integer id, Comentario updateComentario) {
        Comentario comentarioFromDb = findById(id);
        comentarioFromDb.setAutorID(updateComentario.getAutorID());
        comentarioFromDb.setPublicacionID(updateComentario.getPublicacionID());
        comentarioFromDb.setMensaje(updateComentario.getMensaje());
        comentarioFromDb.setComentarioPadre(updateComentario.getComentarioPadre());
        comentarioFromDb.setComentariosHijos(updateComentario.getComentariosHijos());

        return comentarioRepository.save(comentarioFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Comentario comentario = findById(id);
        comentarioRepository.delete(comentario);
    }
}
