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

import com.klinika.pregled.cbrApplication.CBRModelDijagnoza;
import com.klinika.pregled.cbrApplication.CBRService;
import com.klinika.pregled.dto.CBRDijagnozaDTO;
import com.klinika.pregled.dto.DijagnozaDTO;
import com.klinika.pregled.dto.SimptomiDTO;
import com.klinika.pregled.dto.TestDTO;
import com.klinika.pregled.model.Dijagnoza;
import com.klinika.pregled.model.Pacijent;
import com.klinika.pregled.model.Pregled;
import com.klinika.pregled.model.Simptom;
import com.klinika.pregled.model.Test;
import com.klinika.pregled.model.ZdravstveniKarton;
import com.klinika.pregled.repository.DijagnozaRepository;
import com.klinika.pregled.repository.PacijentRepository;
import com.klinika.pregled.repository.PregledRepository;
import com.klinika.pregled.repository.SimptomRepository;
import com.klinika.pregled.repository.TestRepository;
import com.klinika.pregled.repository.ZdravstveniKartonRepository;
import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dijagnoza")
public class DijagnozaController {
	
	@Autowired
	private PregledRepository preglediRepo;
	
	@Autowired
	private PacijentRepository pacijentRepo;
	
	@Autowired
	private SimptomRepository simptomRepo;
	
	@Autowired
	private ZdravstveniKartonRepository zdrRepo;
	
	@Autowired
	private DijagnozaRepository dijagnozaRepo;
	
	@Autowired
	private TestRepository testRepo;
	
	@Autowired
	private CBRService CBRService;

	@GetMapping
	public ResponseEntity<?> getDijagnoze(){
		List<Dijagnoza> dijagnoze = dijagnozaRepo.findAll();
		return new ResponseEntity<List<Dijagnoza>>(dijagnoze, HttpStatus.OK);
	}
	
	@GetMapping("/getAllTestovi")
	public ResponseEntity<?> getTestovi(){
		List<Test> testovi = testRepo.findAll();
		return new ResponseEntity<List<Test>>(testovi, HttpStatus.OK);
	}
	
	@GetMapping("/getAllPregledi")
	public ResponseEntity<?> getPregledi(){
		List<Pregled> pregledi = preglediRepo.findAll();
		return new ResponseEntity<List<Pregled>>(pregledi, HttpStatus.OK);
	}
	
	@GetMapping("/karton/{id}")
	public ResponseEntity<?> getZdravstveniKarton(@PathVariable("id") Long id){
		ZdravstveniKarton k = zdrRepo.getOne(id);
		return new ResponseEntity<ZdravstveniKarton>(k, HttpStatus.OK);
	}
	
	@GetMapping("/getAllpacijenti")
	public ResponseEntity<?> getPacijent(){
		List<Pacijent> pacijent = pacijentRepo.findAll();
		return new ResponseEntity<List<Pacijent>>(pacijent, HttpStatus.OK);
	}
	
	@GetMapping("/getAllSimptomi")
	public ResponseEntity<?> getSimptomi(){
		List<Simptom> simptomi = simptomRepo.findAll();
		return new ResponseEntity<List<Simptom>>(simptomi, HttpStatus.OK);
	}
	
	
	@PostMapping("/saveDijagnoze/{id}")
	public ResponseEntity<?> saveDijagnoze(@RequestBody Set<DijagnozaDTO> dijagnoze, @PathVariable("id") Long id){
		
		Set<Dijagnoza> newDijagnoze = new HashSet<>();
		Pregled pregled = preglediRepo.getOne(id);

		
		for(DijagnozaDTO d : dijagnoze) {
			Dijagnoza newDijagnoza = this.findOneDijagnoza(d.getName());
			System.out.println("***************************************************************");
			System.out.println("Selektovana dijagnoza je : " + newDijagnoza.getName());
			System.out.println("***************************************************************");
			
			newDijagnoze.add(newDijagnoza);
		}
		pregled.setDijagnoze(newDijagnoze);
		Pregled savedPregled = preglediRepo.save(pregled);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/cbr/{id}")
	public ResponseEntity<?> nadjiDijagnozu(@RequestBody Set<TestDTO> testovi, @PathVariable("id") Long id){
		
		Pregled pregled = preglediRepo.getOne(id);
		
		Set<Test> newTestovi = new HashSet<>();

		List<String> cbrTestovi = new ArrayList<String>();
		
		for(TestDTO t : testovi) {
			Test newTest = new Test();
			newTest.setId(t.getId());
			newTest.setName(t.getName());
			newTestovi.add(newTest);
		}
		
		pregled.setTestovi(newTestovi);
		Pregled saved = preglediRepo.save(pregled);
		
		for(Test t : newTestovi) {
			cbrTestovi.add(t.getName());
			System.out.println("Jos jedan test upisan: " + t.getName());
		}
		
		CBRModelDijagnoza newDijagnozaModel = new CBRModelDijagnoza();
		newDijagnozaModel.setTestovi(cbrTestovi);
		List<DijagnozaDTO> listaPogodnih = CBRService.getDijagnozaMatches(newDijagnozaModel);
		
		
		return new ResponseEntity<List<DijagnozaDTO>>(listaPogodnih, HttpStatus.OK);
		
	}
	
	@PostMapping("rbr/{id}")
	public ResponseEntity<?> nadjiDijagnozuRBR(@RequestBody Set<TestDTO> testovi, @PathVariable("id") Long id){
		
		Pregled pregled = preglediRepo.getOne(id);
		
		JIPEngine engine = new JIPEngine();
    	engine.consultFile("data/dijagnoza.pl");
    	
		List<DijagnozaDTO> dijagnoze = new ArrayList<>();
		Set<String> nazivi = new HashSet<>();
		
		Set<Test> newTestovi = new HashSet<>();
		
		for(TestDTO t : testovi) {
			Test newTest = new Test();
			newTest.setId(t.getId());
			newTest.setName(t.getName());
			newTestovi.add(newTest);
		}
		
		pregled.setTestovi(newTestovi);
		Pregled saved = preglediRepo.save(pregled);
		
		for(Test t : newTestovi) {
			String upit = t.getName();
			upit = upit.replace(" ", "_");
	    	upit = upit.toLowerCase();
	    	
	    	JIPQuery query = engine.openSynchronousQuery("diagnosis_for_tests(X," + upit +  ")");
	    	
	    	JIPTerm solution;
			while ( (solution = query.nextSolution()) != null) {
				System.out.println("solution: " + solution);
				
				for (JIPVariable var: solution.getVariables()) {
					System.out.println(var.getName() + "=" + var.getValue());
					
					String result = var.getValue().toString();
					result = result.replace("_", " ");
//					result = result.replace("xthelinex", "-");
					
					result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
					if(!nazivi.contains(result)) {
						dijagnoze.add(new DijagnozaDTO(result));
						nazivi.add(result);
					}
				}
			}
		}
		
		return new ResponseEntity<List<DijagnozaDTO>>(dijagnoze, HttpStatus.OK);
	}
	
	
	private Dijagnoza findOneDijagnoza(String name) {
		List<Dijagnoza> dijagnoze = dijagnozaRepo.findAll();
		for(Dijagnoza d : dijagnoze) {
			if(d.getName().equals(name)) {
				return d;
			}
		}
		return null;
	}
}

