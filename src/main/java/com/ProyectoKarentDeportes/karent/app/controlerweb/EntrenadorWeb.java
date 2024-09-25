package com.ProyectoKarentDeportes.karent.app.controlerweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoKarentDeportes.karent.app.repository.EntrenadorCrud;
import com.ProyectoKarentDeportes.karent.app.variables.Entrenador;

@Controller
public class EntrenadorWeb {

	@Autowired
	private EntrenadorCrud entrenadorRepositorio;

	@GetMapping({ "/verEntrenador" })
	public String verEntrenador(Model model) {
		List<Entrenador> listarEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listarEntrenador", listarEntrenador);

		return "verEntrenador";
	}

	@GetMapping("/verEntrenador/formEntrenador")
	public String mostrarFormulario(Model model) {
		model.addAttribute("entrenador", new Entrenador());
		return "formEntrenador";
	}

	@PostMapping("/guardarEntrenador")
	public String guardarEntrenador(Entrenador entrenador) {
		entrenadorRepositorio.save(entrenador);
		return "redirect:/verEntrenador";
	}

	@GetMapping("/entrenador/editar/{id}")
	public String modificarEntrenador(@PathVariable("id") Integer id, Model model) {
		Entrenador entrenador = entrenadorRepositorio.findById(id).orElse(null);
		if (entrenador != null) {
			model.addAttribute("entrenador", entrenador);
			return "formEntrenador";
		} else {
			return "redirect:/verEntrenador";
		}
	}

	@GetMapping("/entrenador/eliminar/{id}")
	public String eliminarEntrenador(@PathVariable("id") Integer id) {
		entrenadorRepositorio.deleteById(id);
		return "redirect:/verEntrenador";
	}
}
