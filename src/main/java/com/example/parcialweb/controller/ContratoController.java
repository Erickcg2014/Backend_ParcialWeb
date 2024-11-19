package com.example.parcialweb.controller;

import com.example.parcialweb.dto.ContratoDTO;
import com.example.parcialweb.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    // Endpoint para crear un nuevo contrato
    @PostMapping
    public ResponseEntity<ContratoDTO> crearContrato(@RequestBody ContratoDTO contratoDTO) {
        ContratoDTO nuevoContrato = contratoService.crearContrato(contratoDTO);
        return ResponseEntity.status(201).body(nuevoContrato); 
    }

    // Endpoint para actualizar un contrato existente
    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> actualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        ContratoDTO contratoActualizado = contratoService.actualizarContrato(id, contratoDTO);
        return ResponseEntity.ok(contratoActualizado); 
    }

    // Endpoint para eliminar un contrato por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable Long id) {
        contratoService.eliminarContrato(id);
        return ResponseEntity.noContent().build(); 
    }

    // Endpoint para obtener todos los contratos
    @GetMapping
    public ResponseEntity<List<ContratoDTO>> obtenerTodosLosContratos() {
        List<ContratoDTO> contratos = contratoService.obtenerTodosLosContratos();
        return ResponseEntity.ok(contratos); 
    }

    // Endpoint para obtener un contrato por ID
    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> obtenerContratoPorId(@PathVariable Long id) {
        ContratoDTO contrato = contratoService.obtenerContratoPorId(id);
        return ResponseEntity.ok(contrato); 
    }

    // Endpoint para obtener un contrato por identificador único
    @GetMapping("/identificador/{identificador}")
    public ResponseEntity<ContratoDTO> obtenerContratoPorIdentificador(@PathVariable String identificador) {
        ContratoDTO contrato = contratoService.obtenerContratoPorIdentificador(identificador);
        return ResponseEntity.ok(contrato); 
    }
}
