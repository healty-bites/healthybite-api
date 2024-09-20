package com.healthybites.service;
import com.healthybites.model.entity.Progreso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminProgresoService {
    List<Progreso> getAll();
    Page<Progreso> paginate(Pageable pageable);
    Progreso findById(Integer id);
    Progreso create(Progreso progreso);
    Progreso update(Integer id, Progreso updateProgreso);
    void delete(Integer id);
}
