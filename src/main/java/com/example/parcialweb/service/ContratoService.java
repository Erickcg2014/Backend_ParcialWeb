package com.example.parcialweb.service;

import com.example.parcialweb.dto.ContratoDTO;
import com.example.parcialweb.model.Contrato;
import com.example.parcialweb.repository.ContratoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Crear un nuevo contrato
    public ContratoDTO crearContrato(ContratoDTO contratoDTO) {
        // Convertir DTO a Entidad
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        Contrato nuevoContrato = contratoRepository.save(contrato);

        // Convertir Entidad a DTO para devolver la respuesta
        return modelMapper.map(nuevoContrato, ContratoDTO.class);
    }

    // Actualizar un contrato existente
    public ContratoDTO actualizarContrato(Long id, ContratoDTO contratoDTO) {
        Contrato contratoExistente = contratoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrato no encontrado con ID: " + id));

        // Actualizar los valores del contrato existente con los datos del DTO
        contratoExistente.setIdentificador(contratoDTO.getIdentificador());
        contratoExistente.setValor(contratoDTO.getValor());
        contratoExistente.setNombreContratante(contratoDTO.getNombreContratante());
        contratoExistente.setDocumentoContratante(contratoDTO.getDocumentoContratante());
        contratoExistente.setNombreContratantista(contratoDTO.getNombreContratantista());
        contratoExistente.setDocumentoContratantista(contratoDTO.getDocumentoContratantista());
        contratoExistente.setFechaInicial(contratoDTO.getFechaInicial());
        contratoExistente.setFechaFinal(contratoDTO.getFechaFinal());

        // Guardar el contrato actualizado
        Contrato contratoActualizado = contratoRepository.save(contratoExistente);

        // Convertir a DTO para devolver la respuesta
        return modelMapper.map(contratoActualizado, ContratoDTO.class);
    }

    // Eliminar un contrato por ID
    public void eliminarContrato(Long id) {
        if (!contratoRepository.existsById(id)) {
            throw new EntityNotFoundException("Contrato no encontrado con ID: " + id);
        }
        contratoRepository.deleteById(id);
    }

    // Obtener todos los contratos
    public List<ContratoDTO> obtenerTodosLosContratos() {
        List<Contrato> contratos = (List<Contrato>) contratoRepository.findAll();
        return contratos.stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }

    // Obtener un contrato por ID
    public ContratoDTO obtenerContratoPorId(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrato no encontrado con ID: " + id));
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    // Obtener un contrato por su identificador único
    public ContratoDTO obtenerContratoPorIdentificador(String identificador) {
        Contrato contrato = contratoRepository.findByIdentificador(identificador);
        if (contrato == null) {
            throw new EntityNotFoundException("Contrato no encontrado con identificador: " + identificador);
        }
        return modelMapper.map(contrato, ContratoDTO.class);
    }
}
