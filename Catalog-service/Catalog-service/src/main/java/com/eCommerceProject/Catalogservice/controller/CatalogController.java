package com.eCommerceProject.Catalogservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerceProject.Catalogservice.entity.Catalog;
import com.eCommerceProject.Catalogservice.repository.CatalogRepository;

@RestController
public class CatalogController {

	@Autowired
	private CatalogRepository catalogRepository;
	
	@PostMapping("/createCatalogs")
	public Catalog saveProducts(@RequestBody Catalog catalog) {
		
		Catalog catalogs=catalogRepository.save(catalog);
		
		return new Catalog(catalogs.getCatalogId(),catalogs.getName(),catalogs.getDescription(),
				catalogs.getImage(),catalogs.getCreatedAt(),catalogs.getUpdatedAt());
	}
	
	@GetMapping("/getAllCatalogs")
	public List<Catalog> getCatalogs() {
		
		List<Catalog> catalogs =catalogRepository.findAll();
		
		System.out.println(catalogs);
		
		return catalogs;
	}
	
	@GetMapping("/catalogs/{id}")
	public Optional<Catalog> getCatalogId(@PathVariable String catalogId) {
		
		Optional<Catalog> catalogs =catalogRepository.findById(catalogId);
		
		System.out.println(catalogs);
		
		return catalogs;
	}
	
	@PutMapping(value="/catalogs/{id}")
	public String updateCatalogId(@PathVariable String catalogId,@RequestBody Catalog catalogs) {
		
		if(catalogId!= null) {
			boolean isIdAvailable=catalogRepository.existsById(catalogId);
			if(isIdAvailable==true) {
				Catalog catalog1=new Catalog(catalogs.getCatalogId(),catalogs.getName(),catalogs.getDescription(),
						catalogs.getImage(),catalogs.getCreatedAt(),catalogs.getUpdatedAt());
				
				Catalog use=catalogRepository.save(catalog1);
				
				return "sucessfull";
			
			}else {
				return "id is not available";
			}
			
		}
		return "enter a valid id";
			
	}
	
	@DeleteMapping(value="/catalog/{id}")
	public String deleteCatalogId(@PathVariable String catalogId) {
		
		if(catalogId!= null) {
			boolean isIdAvailable=catalogRepository.existsById(catalogId);
			if(isIdAvailable==true) {
				
				
				catalogRepository.deleteById(catalogId);
				
				return "sucessfull deleted";
			
			}else {
				return "id is not available";
			}
			
		}
		return "enter a valid id";
			
	}
	
}
