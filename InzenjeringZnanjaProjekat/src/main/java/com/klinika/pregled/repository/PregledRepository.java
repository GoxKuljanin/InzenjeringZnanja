package com.klinika.pregled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinika.pregled.model.Pregled;

public interface PregledRepository extends JpaRepository<Pregled, Long>{

}
