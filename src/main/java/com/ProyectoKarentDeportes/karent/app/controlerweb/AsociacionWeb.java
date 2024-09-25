package com.ProyectoKarentDeportes.karent.app.controlerweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoKarentDeportes.karent.app.repository.AsociacionCrud;
import com.ProyectoKarentDeportes.karent.app.variables.Asociacion;

@Controller
public class AsociacionWeb {

	@Autowired
	private AsociacionCrud asociacionRepositorio;

	@GetMapping({ "/verAsociacion" })
	public String verAsociacion(Model model) {
		List<Asociacion> listarAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listarAsociacion", listarAsociacion);

		return "verAsociacion";
	}

	@GetMapping("/verAsociacion/formAsociacion")
	public String mostrarFormulario(Model model) {
		model.addAttribute("asociacion", new Asociacion());
		return "formAsociacion";
	}

	@PostMapping("/guardarAsociacion")
	public String guardarAsociacion(Asociacion asociacion) {
		asociacionRepositorio.save(asociacion);
		return "redirect:/verAsociacion";
	}

	@GetMapping("/asociacion/editar/{id}")
	public String modificarAsociacion(@PathVariable("id") Integer id, Model model) {
		Asociacion asociacion = asociacionRepositorio.findById(id).orElse(null);
		if (asociacion != null) {
			model.addAttribute("asociacion", asociacion);
			return "formAsociacion";
		} else {
			return "redirect:/verAsociacion";
		}
	}

	@GetMapping("/asociacion/eliminar/{id}")
	public String eliminarAsociacion(@PathVariable("id") Integer id) {
		asociacionRepositorio.deleteById(id);
		return "redirect:/verAsociacion";
	}
}
