package com.ProyectoKarentDeportes.karent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoKarentDeportes.karent.app.variables.Entrenador;

public interface EntrenadorCrud extends JpaRepository<Entrenador, Integer> {

}
