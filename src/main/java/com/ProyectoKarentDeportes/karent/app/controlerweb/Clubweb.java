package com.ProyectoKarentDeportes.karent.app.controlerweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoKarentDeportes.karent.app.repository.AsociacionCrud;
import com.ProyectoKarentDeportes.karent.app.repository.ClubCrud;
import com.ProyectoKarentDeportes.karent.app.repository.CompeticionCrud;
import com.ProyectoKarentDeportes.karent.app.repository.EntrenadorCrud;
import com.ProyectoKarentDeportes.karent.app.variables.Asociacion;
import com.ProyectoKarentDeportes.karent.app.variables.Club;
import com.ProyectoKarentDeportes.karent.app.variables.Competicion;
import com.ProyectoKarentDeportes.karent.app.variables.Entrenador;

@Controller
public class Clubweb {

	@Autowired
	private ClubCrud clubcrud;

	@Autowired
	private EntrenadorCrud enrenadorcrud;

	@Autowired
	private AsociacionCrud asociacioncrud;

	@Autowired
	private CompeticionCrud competicioncrud;

	@GetMapping({ "/verClub" })
	public String verClub(Model model) {
		List<Club> listaClub = clubcrud.findAllWithCompeticiones();
		model.addAttribute("listaClub", listaClub);
		return "verClub";
	}

	@GetMapping("/verClub/formClub")
	public String mostrarFormulario(Model model) {
		model.addAttribute("club", new Club());

		List<Entrenador> listaEntrenador = enrenadorcrud.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);

		List<Asociacion> listaAsociacion = asociacioncrud.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);

		List<Competicion> listaCompeticion = competicioncrud.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);

		return "formClub";
	}

	@PostMapping("/guardarClub")
	public String guardarClub(Club club) {
		clubcrud.save(club);
		return "redirect:/verClub";
	}

	@GetMapping("/club/editar/{id}")
	public String modificarClub(@PathVariable("id") Integer id, Model model) {
		Club club = clubcrud.findById(id).get();
		model.addAttribute("club", club);

		List<Entrenador> listaEntrenador = enrenadorcrud.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);

		List<Asociacion> listaAsociacion = asociacioncrud.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);

		List<Competicion> listaCompeticion = competicioncrud.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);

		return "formClub";
	}

	@GetMapping("/club/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		clubcrud.deleteById(id);
		return "redirect:/verClub";
	}

}
