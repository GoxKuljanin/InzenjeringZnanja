package com.klinika.pregled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinika.pregled.model.Lek;

public interface LekRepository extends JpaRepository<Lek, Long> {

}

