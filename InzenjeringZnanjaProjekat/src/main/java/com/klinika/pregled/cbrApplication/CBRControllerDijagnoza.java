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

import com.klinika.pregled.dto.CBRDijagnozaDTO;
import com.klinika.pregled.dto.CBRResponseDTO;
import com.klinika.pregled.dto.CBRResponseDijagnozaDTO;
import com.klinika.pregled.dto.CBRSimptomDTO;
import com.klinika.pregled.dto.CBRTestDTO;
import com.klinika.pregled.dto.CBRTestoviDTO;
import com.klinika.pregled.model.Test;
import com.klinika.pregled.repository.PregledRepository;
import com.klinika.pregled.repository.TestRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cbrDijagnoza")
public class CBRControllerDijagnoza {

    @Autowired
    private PregledRepository pregledRepository;

    @Autowired
    private CBRServiceDijagnoza service;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private CBRServiceDijagnoza serviceDijagnoza;

    @GetMapping
    public List<CBRResponseDijagnozaDTO> getCBRResponse(){
        /*Test t = testRepository.findById(3L).get();

        CBRTestoviDTO cbr1 = new CBRTestoviDTO();
        cbr1.setId(1L);
        List<String> testovi = new ArrayList<>();
        testovi.add("Radiographic imaging procedure");
        testovi.add("X ray");
//		simptomi.add("alcohol_abuse");
//		simptomi.add("migraine");
        cbr1.setTestovi(testovi);


        List<CBRResponseDijagnozaDTO> cbrresponse = new ArrayList<>();

        CBRModelDijagnoza newModel = new CBRModelDijagnoza();
        newModel.setTestovi(testovi);
        List<CBRResponseDijagnozaDTO> listam = serviceDijagnoza.getMatches(newModel);
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
        return listam;*/
    	return null;
    }

	/*@GetMapping("/test")
	public ResponseEntity<?> getTestove(){
		CBRSimptomDTO cbr1 = new CBRSimptomDTO();
		cbr1.setId(1L);
		List<String> simptomi = new ArrayList<>();
		simptomi.add("Seizure");
		simptomi.add("Abnormal involuntary movements");
//		simptomi.add("alcohol_abuse");
//		simptomi.add("migraine");
		cbr1.setSimptomi(simptomi);

		CBRModelTest newModel = new CBRModelTest();
		newModel.setSimptomi(simptomi);
		List<CBRTestDTO> listat = service.getTestMatches(newModel);

		System.out.println("---------------------------");
		System.out.println(listat);

		return new ResponseEntity<List<CBRTestDTO>>(listat, HttpStatus.OK);
	}*/

    @GetMapping("/dijagnoza")
    public void getDijagnoze(){
        CBRTestoviDTO cbr1 = new CBRTestoviDTO();
        cbr1.setId(1L);
        List<String> testovi = new ArrayList<>();
        testovi.add("Radiographic imaging procedure");
        testovi.add("X ray");
//		simptomi.add("alcohol_abuse");
//		simptomi.add("migraine");
        cbr1.setTestovi(testovi);

        CBRModelDijagnoza newModel = new CBRModelDijagnoza();
        newModel.setTestovi(testovi);
//        List<CBRTestDTO> listaDijagnoza = serviceDijagnoza.getDijagnozaMatches(newModel);
//
//        System.out.println("---------------------------");
//        System.out.println(listaDijagnoza);
//
//        return new ResponseEntity<List<CBRTestDTO>>(listaDijagnoza, HttpStatus.OK);
    }
}