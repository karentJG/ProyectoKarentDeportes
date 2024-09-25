package com.ProyectoKarentDeportes.karent.app.controlerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexWeb {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
}