package com.klinika.pregled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinika.pregled.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent, Long>{

}
