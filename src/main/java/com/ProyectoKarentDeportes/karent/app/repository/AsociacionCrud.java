package com.ProyectoKarentDeportes.karent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoKarentDeportes.karent.app.variables.Asociacion;

public interface AsociacionCrud extends JpaRepository<Asociacion, Integer> {

}
