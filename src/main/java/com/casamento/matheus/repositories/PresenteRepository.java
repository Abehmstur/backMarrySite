package com.casamento.matheus.repositories;

import com.casamento.matheus.entities.Presente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PresenteRepository extends JpaRepository<Presente , UUID> {
}
