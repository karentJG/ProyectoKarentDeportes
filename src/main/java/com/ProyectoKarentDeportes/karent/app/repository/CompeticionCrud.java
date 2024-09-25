package com.ProyectoKarentDeportes.karent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoKarentDeportes.karent.app.variables.Competicion;

public interface CompeticionCrud extends JpaRepository<Competicion, Integer> {

}
