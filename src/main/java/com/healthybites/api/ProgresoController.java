package com.healthybites.api;

import com.healthybites.model.entity.RegistroProgreso;
import com.healthybites.model.entity.RegistroProgreso;
import com.healthybites.repository.RegistrarProgresoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProgresoController {

    private final RegistrarProgresoRepository registrarProgresoRepository;

    public ProgresoController(RegistrarProgresoRepository registrarProgresoRepository){
        this.registrarProgresoRepository=registrarProgresoRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/listar_progreso")
    public ResponseEntity<List<RegistroProgreso>> getAllProgreso(){
        return new ResponseEntity<List<RegistroProgreso>>(registrarProgresoRepository.findAll(), HttpStatus.OK);
    }
}
