package com.example.parcialweb.repository;

import com.example.parcialweb.model.Contrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Long> {

    // Verificar si un contrato existe por su identificador único
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Contrato c WHERE c.identificador = :identificador")
    boolean existsByIdentificador(@Param("identificador") String identificador);

    // Encontrar un contrato por su identificador único
    @Query("SELECT c FROM Contrato c WHERE c.identificador = :identificador")
    Contrato findByIdentificador(@Param("identificador") String identificador);

    // Encontrar un contrato por su ID
    @Query("SELECT c FROM Contrato c WHERE c.id = :id")
    Contrato findByIdCustom(@Param("id") Long id);
}
