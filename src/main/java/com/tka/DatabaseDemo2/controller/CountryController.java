package com.tka.DatabaseDemo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.DatabaseDemo2.entity.Country;
import com.tka.DatabaseDemo2.service.CountryService;

@RestController
@RequestMapping("countryApi")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	
	
	@PostMapping("addrecord")
	public ResponseEntity<String> addRecord(@RequestBody Country country) {
		String msg = countryService.addRecord(country);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updaterecord/{c_id}")
	public ResponseEntity<String> updataRecord(@RequestBody Country country, @PathVariable int c_id) {
		String msg =countryService.updataRecord(country,c_id);
		
		return ResponseEntity.ok(msg);
	}
	
	
	@DeleteMapping("deleterecord/{c_id}")
	public ResponseEntity<String> deleteRecord(@PathVariable int c_id) {
		String msg =countryService.deleteRecord(c_id);
		
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Country>> getAllData() {
		List<Country> list = countryService.getAllData();
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("getparticular/{c_id}")
	public ResponseEntity<Country> getParticular(@PathVariable int c_id) {
		Country country = countryService.getParticular(c_id);
		return ResponseEntity.ok(country);
	}
	
}
