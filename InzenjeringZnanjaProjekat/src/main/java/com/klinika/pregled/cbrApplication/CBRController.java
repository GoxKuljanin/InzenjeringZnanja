package com.klinika.pregled.cbrApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klinika.pregled.dto.CBRResponseDTO;
import com.klinika.pregled.dto.CBRSimptomDTO;
import com.klinika.pregled.dto.CBRTestDTO;
import com.klinika.pregled.model.Pregled;
import com.klinika.pregled.repository.PregledRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cbr")
public class CBRController {

	@Autowired
	private PregledRepository pregledRepository;
	
	@Autowired
	private CBRService service;
	
	@GetMapping
	public List<CBRResponseDTO> getCBRResponse(){
		Pregled p = pregledRepository.findById(3L).get();
		
		CBRSimptomDTO cbr1 = new CBRSimptomDTO();
		cbr1.setId(1L);
		List<String> simptomi = new ArrayList<>();
		simptomi.add("Headache");
		simptomi.add("Dizziness");
//		simptomi.add("alcohol_abuse");
//		simptomi.add("migraine");
		cbr1.setSimptomi(simptomi);
		
		List<CBRResponseDTO> cbrresponse = new ArrayList<>();
		
		CBRModelPregled newModel = new CBRModelPregled();
		newModel.setSimptom(simptomi);
		List<CBRResponseDTO> listam = service.getMatches(newModel);
		System.out.println("---------------------------");
		System.out.println(listam);
		
//		for(String simptom : cbr1.getSimptomi()) {
//			CBRModelSimptomPregled model = new CBRModelSimptomPregled();
//			model.setSimptom(simptomi);
//			List<CBRResponseDTO> listam = service.getMatches(model);
//			System.out.println("---------------------------");
//			System.out.println(listam);
//			cbrresponse.addAll(listam);
//		}
		return listam;
	}
	
//	@GetMapping("/test")
//	public ResponseEntity<?> getTestove(){
//		CBRSimptomDTO cbr1 = new CBRSimptomDTO();
//		cbr1.setId(1L);
//		List<String> simptomi = new ArrayList<>();
//		simptomi.add("Seizure");
//		simptomi.add("Abnormal involuntary movements");
////		simptomi.add("alcohol_abuse");
////		simptomi.add("migraine");
//		cbr1.setSimptomi(simptomi);
//		
//		CBRModelTest newModel = new CBRModelTest();
//		newModel.setSimptomi(simptomi);
//		List<CBRTestDTO> listat = service.getTestMatches(newModel);
//		
//		System.out.println("---------------------------");
//		System.out.println(listat);
//		
//		return new ResponseEntity<List<CBRTestDTO>>(listat, HttpStatus.OK);
//	}
}
