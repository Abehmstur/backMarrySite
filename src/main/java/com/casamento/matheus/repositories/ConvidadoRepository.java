package com.casamento.matheus.repositories;

import com.casamento.matheus.entities.Convidado;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, UUID> {
}
