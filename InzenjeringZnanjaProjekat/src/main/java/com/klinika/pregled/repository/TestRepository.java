package com.klinika.pregled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinika.pregled.model.Test;

public interface TestRepository extends JpaRepository<Test, Long>{

}
