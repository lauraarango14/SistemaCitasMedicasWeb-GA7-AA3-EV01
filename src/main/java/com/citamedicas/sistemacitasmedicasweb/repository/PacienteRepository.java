package com.citamedicas.sistemacitasmedicasweb.repository;

import com.citamedicas.sistemacitasmedicasweb.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para realizar las operaciones CRUD
 * de la entidad Paciente.
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}