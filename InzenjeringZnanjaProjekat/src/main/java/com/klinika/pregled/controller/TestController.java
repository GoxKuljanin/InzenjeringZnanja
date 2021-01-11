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
import com.klinika.pregled.cbrApplication.CBRModelLek;
import com.klinika.pregled.cbrApplication.CBRModelTest;
import com.klinika.pregled.cbrApplication.CBRService;
import com.klinika.pregled.cbrApplication.CBRServiceDijagnoza;
import com.klinika.pregled.dto.CBRDijagnozaDTO;
import com.klinika.pregled.dto.CBRLekDTO;
import com.klinika.pregled.dto.CBRTestDTO;
import com.klinika.pregled.dto.TestDTO;
import com.klinika.pregled.model.Dijagnoza;
import com.klinika.pregled.model.Pacijent;
import com.klinika.pregled.model.Pregled;
import com.klinika.pregled.model.Simptom;
import com.klinika.pregled.model.Test;
import com.klinika.pregled.model.ZdravstveniKarton;
import com.klinika.pregled.repository.PacijentRepository;
import com.klinika.pregled.repository.PregledRepository;
import com.klinika.pregled.repository.SimptomRepository;
import com.klinika.pregled.repository.TestRepository;
import com.klinika.pregled.repository.ZdravstveniKartonRepository;
import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
//
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestRepository testoviRepo;
    
    @Autowired
    private PacijentRepository pacijentRepo;
    
    @Autowired
    private ZdravstveniKartonRepository zdrRepo;
    
    @Autowired
	private CBRServiceDijagnoza cBRServiceDjagnoza;
    
    @Autowired
	private CBRService CBRService;
    
    @Autowired
	private SimptomRepository simptomRepo;
    
    @Autowired
	private PregledRepository preglediRepo;

    @GetMapping("/getAllTestovi")
    public ResponseEntity<?> getTestovi(){
        List<Test> testovi = testoviRepo.findAll();
        return new ResponseEntity<List<Test>>(testovi, HttpStatus.OK);
    }
    
    @GetMapping("/pacijent")
	public ResponseEntity<?> getPacijent(){
		List<Pacijent> pacijent = pacijentRepo.findAll();
		return new ResponseEntity<List<Pacijent>>(pacijent, HttpStatus.OK);
	}
	
    /*@PostMapping("/dijagnoza")
	public ResponseEntity<?> dodajTest(@RequestBody Pregled pregled){
		
    	
    	ArrayList<String> listat = new ArrayList<String>();
		
		CBRModelDijagnoza newModelDijagnoza = new CBRModelDijagnoza();
		newModelDijagnoza.setTestovi(listat);
		
		List<CBRTestDTO> listaDijagnoza = cBRServiceDjagnoza.getDijagnozaMatches(newModelDijagnoza);
		
		return new ResponseEntity<List<CBRTestDTO>>(listaDijagnoza, HttpStatus.OK);
	}*/
    
    
    /*@PostMapping("/{id}")
	public ResponseEntity<?> nadjiDijagnozu(@RequestBody Set<Test> testovi, @PathVariable("id") Long id){
		List<String> cbrTestovi = new ArrayList<String>();
		for(Test t : testovi) {
			cbrTestovi.add(t.getName());
		}
		CBRModelTest newDijagnozaModel = new CBRModelTest();
		newDijagnozaModel.setSimptomi(cbrTestovi);
		List<CBRTestDTO> listaPogodnih = CBRService.getTestMatches(newDijagnozaModel);
		return new ResponseEntity<List<CBRTestDTO>>(listaPogodnih, HttpStatus.OK);
		
	}*/
    
    @PostMapping("/rbr/{id}")
	public ResponseEntity<?> findDijagnoze(@RequestBody Test test, @PathVariable("id") Long id){
		Set<String> nazivi = new HashSet<>();
		List<TestDTO> dijagnoze = new ArrayList<>();
		
		JIPEngine engine = new JIPEngine();
    	engine.consultFile("data/program.pl");
    	
    	ZdravstveniKarton karton = zdrRepo.getOne(id);
		Test newT = new Test();
		Set<Simptom> newS = new HashSet<>();
		Set<Simptom> simptomi = new HashSet<>();  //test.getSimptomi();
		
		for(Simptom sim : simptomi) {
			String upit = sim.getName();
			upit = upit.replace(" ", "_");
	    	upit = upit.toLowerCase();
	    	
	    	JIPQuery query = engine.openSynchronousQuery("procedure_for_symptoms(X," + upit +  ")");
	    	
	    	JIPTerm solution;
			while ( (solution = query.nextSolution()) != null) {
				System.out.println("solution: " + solution);
				
				for (JIPVariable var: solution.getVariables()) {
					System.out.println(var.getName() + "=" + var.getValue());
					
					String result = var.getValue().toString();
					result = result.replace("_", " ");
					
					result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
					if(!nazivi.contains(result)) {
						dijagnoze.add(new TestDTO(result));
						nazivi.add(result);
					}
				}
			}
		}
		
		return new ResponseEntity<List<TestDTO>>(dijagnoze, HttpStatus.OK);
	}
}