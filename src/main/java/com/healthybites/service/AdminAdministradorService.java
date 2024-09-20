package com.healthybites.service;

import com.healthybites.model.entity.Administrador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminAdministradorService {
    List<Administrador> getAll();
    Page<Administrador> paginate(Pageable pageable);
    Administrador findById(Integer id);
    Administrador create(Administrador contenido);
    Administrador update(Integer id, Administrador updateContenido);
    void delete(Integer id);
}
