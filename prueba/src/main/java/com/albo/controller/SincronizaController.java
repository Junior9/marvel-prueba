package com.albo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.albo.service.SincronizarService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SincronizaController {
	
	@Autowired
	private SincronizarService sincronizaService;

	@PostMapping(value="/sincroniza")
	public String getColaboratorsByCharacterName(@RequestBody String datos) {
		JSONObject datoJson = new JSONObject(datos);
		this.sincronizaService.sincronizaDataBase(datoJson);
		return new JSONObject().put("stutus", true).toString();
	} 
	
	@GetMapping("/history")
	@ResponseBody
	public String getHistory() {
		return this.sincronizaService.getHistory().toString();
	}
	
	@GetMapping("/agenda")
	@ResponseBody
	public String agendaSincronizacion() throws InterruptedException {
		this.sincronizaService.sincro();
		return new JSONObject().put("status", true).toString();
	}
	
	@GetMapping("/marvel/prueba")
	public String setDatosPrueba() {
		this.sincronizaService.setDatosPrueba();
		return new JSONObject().put("result", "OK").toString();
	}
}