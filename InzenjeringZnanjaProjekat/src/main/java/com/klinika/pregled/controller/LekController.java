package com.klinika.pregled.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klinika.pregled.cbrApplication.CBRModelLek;
import com.klinika.pregled.cbrApplication.CBRModelTest;
import com.klinika.pregled.cbrApplication.CBRService;
import com.klinika.pregled.dto.CBRLekDTO;
import com.klinika.pregled.dto.DijagnozaDTO;
import com.klinika.pregled.dto.LekDTO;
import com.klinika.pregled.dto.SimptomiDTO;
import com.klinika.pregled.dto.TestDTO;
import com.klinika.pregled.model.Lek;
import com.klinika.pregled.model.Pregled;
import com.klinika.pregled.model.Simptom;
import com.klinika.pregled.model.Test;
import com.klinika.pregled.model.ZdravstveniKarton;
import com.klinika.pregled.model.Dijagnoza;
import com.klinika.pregled.repository.LekRepository;
import com.klinika.pregled.repository.PregledRepository;
import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import com.klinika.pregled.repository.DijagnozaRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/lek")
public class LekController {

	@Autowired
	private PregledRepository preglediRepo;
	
	@Autowired
	private LekRepository lekRepository;
	
	@Autowired
	private DijagnozaRepository dijagnozaRepository;
	
	@Autowired
	private CBRService CBRService;
	
	@GetMapping
	public ResponseEntity<?> getLekovi(){
		List<Lek> lekovi = lekRepository.findAll();
		return new ResponseEntity<List<Lek>>(lekovi, HttpStatus.OK);
	}
	
	@GetMapping("/getAllDijagnoza")
	public ResponseEntity<?> getDijagnoze(){
		List<Dijagnoza> dijagnoze = dijagnozaRepository.findAll();
		return new ResponseEntity<List<Dijagnoza>>(dijagnoze, HttpStatus.OK);
	}
	
	@PostMapping("cbr/{id}")
	public ResponseEntity<List<LekDTO>> nadjiTerapiju(@RequestBody Set<DijagnozaDTO> dijagnoze, @PathVariable("id") Long id){ 
		Pregled pregled = preglediRepo.getOne(id);
		
		Set<Dijagnoza> newDijagnoze = new HashSet<>();
		
		for(DijagnozaDTO s : dijagnoze) {
			Dijagnoza newDijagnoza = new Dijagnoza(s.getName());
			newDijagnoza.setId(s.getId());
			newDijagnoze.add(newDijagnoza);
		}
		pregled.setDijagnoze(newDijagnoze);
		
		List<String> cbrDijagnoze = new ArrayList<String>();
		for(Dijagnoza d : newDijagnoze) {
			cbrDijagnoze.add(d.getName());
		}
		
		CBRModelLek newModel = new CBRModelLek();
		newModel.setDijagnoze(cbrDijagnoze);
		List<LekDTO> listal = CBRService.getLekMatches(newModel);

		List<LekDTO> lekoviFiltered = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			if( i < listal.size()) {
				lekoviFiltered.add(listal.get(i));
			}else {
				break;
			}
		}
		Pregled saved = preglediRepo.save(pregled); 
		
		return new ResponseEntity<List<LekDTO>>(lekoviFiltered, HttpStatus.OK);
		//
	}
	
	@PostMapping("rbr/{id}")
	public ResponseEntity<?> nadjiTerapijuRBR(@RequestBody Set<DijagnozaDTO> dijagnoze, @PathVariable("id") Long id){
		Pregled pregled = preglediRepo.getOne(id);
		List<LekDTO> lekovi = new ArrayList<>();
		Set<String> nazivi = new HashSet<>();
		JIPEngine engine = new JIPEngine();
    	engine.consultFile("data/terapija.pl");

		Set<Dijagnoza> newDijagnoze = new HashSet<>();
    	for(DijagnozaDTO d : dijagnoze) {
    		Dijagnoza newDijganoza = new Dijagnoza(d.getName());
    		newDijganoza.setId(d.getId());
    		newDijagnoze.add(newDijganoza);
		}
		pregled.setDijagnoze(newDijagnoze);
		
		for(Dijagnoza d : newDijagnoze) {
			String upit = d.getName();
			upit = upit.replace(" ", "_");
	    	upit = upit.toLowerCase();
	    	
	    	JIPQuery query = engine.openSynchronousQuery("medicine_for_diagnosis(X," + upit +  ")");
	    	
	    	JIPTerm solution;
			while ( (solution = query.nextSolution()) != null) {
				System.out.println("solution: " + solution);
				
				for (JIPVariable var: solution.getVariables()) {
					System.out.println(var.getName() + "=" + var.getValue());
					
					String result = var.getValue().toString();
					result = result.replace("_", " ");
					result = result.replace("xthelinex", "-");
					
					result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
					if(!nazivi.contains(result)) {
						lekovi.add(new LekDTO(result));
						nazivi.add(result);
					}
				}
			}
		}

		List<LekDTO> lekoviFiltered = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			if( i < lekovi.size()) {
				lekoviFiltered.add(lekovi.get(i));
			}else {
				break;
			}
		}
		Pregled saved = preglediRepo.save(pregled); 
		
		return new ResponseEntity<List<LekDTO>>(lekoviFiltered, HttpStatus.OK);
	}
	

	
	@PostMapping("/lek/{id}")
	public ResponseEntity<?> saveLekove(@RequestBody Set<LekDTO> lekovi, @PathVariable("id") Long id){
		
		Set<Lek> newLekovi = new HashSet<>();
		Pregled pregled = preglediRepo.getOne(id);
		
		for(LekDTO l : lekovi) {
			Lek newLek = this.findOneLek(l.getName());
			System.out.println("***************************************************************");
			System.out.println("Selektovani lek je : " + newLek.getName());
			System.out.println("***************************************************************");
			newLekovi.add(newLek);
		}
		pregled.setLekovi(newLekovi);
		Pregled savedPregled = preglediRepo.save(pregled);
		return new ResponseEntity<>(savedPregled,HttpStatus.OK);
	}
	
	private Lek findOneLek(String name) {
		List<Lek> lekovi = lekRepository.findAll();
		for(Lek l : lekovi) {
			if(l.getName().equals(name)) {
				return l;
			}
		}
		return null;
	}
}
