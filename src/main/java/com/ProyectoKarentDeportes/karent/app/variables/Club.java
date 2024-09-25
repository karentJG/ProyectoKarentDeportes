package com.ProyectoKarentDeportes.karent.app.variables;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clubes")
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	@OneToOne
	@JoinColumn(name = "entrenador_id", referencedColumnName = "id")
	private Entrenador entrenador;

	@OneToMany(mappedBy = "club")
	private List<Jugador> jugadores;

	@ManyToOne
	@JoinColumn(name = "asociacion_id", referencedColumnName = "id")
	private Asociacion asociacion;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "club_competicion", joinColumns = @JoinColumn(name = "club_id"), inverseJoinColumns = @JoinColumn(name = "competicion_id"))
	private List<Competicion> competiciones;

	public Club() {
	}

	public Club(Integer id, String nombre, Entrenador entrenador, List<Jugador> jugadores, Asociacion asociacion,
			List<Competicion> competiciones) {
		this.id = id;
		this.nombre = nombre;
		this.entrenador = entrenador;
		this.jugadores = jugadores;
		this.asociacion = asociacion;
		this.competiciones = competiciones;
	}

	// Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public List<Competicion> getCompeticiones() {
		return competiciones;
	}

	public void setCompeticiones(List<Competicion> competiciones) {
		this.competiciones = competiciones;
	}
}
