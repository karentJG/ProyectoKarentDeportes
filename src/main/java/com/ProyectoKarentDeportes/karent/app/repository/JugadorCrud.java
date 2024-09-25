package com.ProyectoKarentDeportes.karent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoKarentDeportes.karent.app.variables.Jugador;

public interface JugadorCrud extends JpaRepository<Jugador, Integer> {

}