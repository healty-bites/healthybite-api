package com.healthybites.service;


import com.healthybites.model.entity.Publicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminPublicacionService {
    List<Publicacion> getAll();
    Page<Publicacion> paginate(Pageable pageable);
    Publicacion findById(Integer id);
    Publicacion create(Publicacion contenido);
    Publicacion update(Integer id, Publicacion updateContenido);
    void delete(Integer id);
}
