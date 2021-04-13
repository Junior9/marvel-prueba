package com.albo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> getColaboratorsByCharacterName(@RequestBody String datos) {
		JSONObject datoJson = new JSONObject(datos);
		this.sincronizaService.sincronizaDataBase(datoJson);
		JSONObject json = new JSONObject().put("status", true);
		ResponseEntity<String> response = new ResponseEntity<String>(json.toString(), HttpStatus.OK);
		return response;
	} 
	
	@GetMapping("/history")
	@ResponseBody
	public ResponseEntity<String> getHistory() {
		String jsonResponse = this.sincronizaService.getHistory().toString();
		ResponseEntity<String> response = new ResponseEntity<String>(jsonResponse, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/agenda")
	@ResponseBody
	public ResponseEntity<String> agendaSincronizacion() throws InterruptedException {
		this.sincronizaService.sincro();
		JSONObject json = new JSONObject().put("status", true);
		ResponseEntity<String> response = new ResponseEntity<String>(json.toString(), HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/marvel/prueba")
	public ResponseEntity<String> setDatosPrueba() {
		this.sincronizaService.setDatosPrueba();	
		JSONObject json = new JSONObject().put("status", true);
		ResponseEntity<String> response = new ResponseEntity<String>(json.toString(), HttpStatus.OK);
		return response;
	}
}