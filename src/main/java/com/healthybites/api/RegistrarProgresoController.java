package com.healthybites.api;

import com.healthybites.model.entity.RegistroProgreso;
import com.healthybites.repository.RegistrarProgresoRepository;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin

public class RegistrarProgresoController {

    private final RegistrarProgresoRepository registrarProgresoRepository;

    public RegistrarProgresoController(RegistrarProgresoRepository registrarProgresoRepository) {  // Cambiar "Controler" a "Controller"
        this.registrarProgresoRepository = registrarProgresoRepository;
    }

    @Transactional(readOnly = true)
    @PostMapping("/registro_progreso")
    public ResponseEntity<RegistroProgreso> createregistroPogreso(@RequestBody RegistroProgreso registroProgreso){
        validateRegistroProgreso(registroProgreso);
        return new ResponseEntity<RegistroProgreso>(registrarProgresoRepository.save(registroProgreso), HttpStatus.CREATED);
    }

    private void validateRegistroProgreso(RegistroProgreso registroProgreso){

        if(registroProgreso.getPesoActual()<0){
            throw new ValidationException("El peso Actual es negativo");
        }

        if(registroProgreso.getPesoActual()>1000){
            throw new ValidationException("El peso Actual es mayor que 1000");
        }
    }

}
