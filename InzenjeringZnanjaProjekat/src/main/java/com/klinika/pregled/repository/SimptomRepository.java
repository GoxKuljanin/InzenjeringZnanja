package com.klinika.pregled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinika.pregled.model.Simptom;

public interface SimptomRepository extends JpaRepository<Simptom, Long> {

}
