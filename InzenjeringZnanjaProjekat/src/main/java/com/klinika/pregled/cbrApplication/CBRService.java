package com.klinika.pregled.cbrApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klinika.pregled.dto.CBRDijagnozaDTO;
import com.klinika.pregled.dto.CBRLekDTO;
import com.klinika.pregled.dto.CBRResponseDTO;
import com.klinika.pregled.dto.CBRTestDTO;

import com.klinika.pregled.dto.DijagnozaDTO;

import com.klinika.pregled.dto.LekDTO;

import com.klinika.pregled.dto.TestDTO;
import com.klinika.pregled.repository.DijagnozaRepository;
import com.klinika.pregled.repository.LekRepository;
import com.klinika.pregled.repository.PregledRepository;
//
//import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
//import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;
import com.klinika.pregled.repository.TestRepository;

import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

@Service
public class CBRService {

	@Autowired
	private PregledRepository repo;

	@Autowired
	private TestRepository testRepo;
	
	@Autowired
	private LekRepository lekRepository;
	
	@Autowired
	private DijagnozaRepository dijagnozaRepo;
	
	public List<CBRResponseDTO> getMatches(CBRModelPregled cbr){
		CbrApplication app = new CbrApplication(repo.findAll());
		
		Collection<RetrievalResult> eval = app.evaluate(cbr);
		eval = SelectCases.selectTopKRR(eval, 5);
		
		ArrayList<CBRResponseDTO> rezultati = new ArrayList<>();
		for(RetrievalResult r : eval) {
			if(r.getEval() > 0) {
				CBRResponseDTO novi = new CBRResponseDTO();
				novi.setDijagnoza(((CBRModelPregled)r.get_case().getDescription()).getDijagnoza());;
				//novi.setId(((CBRModelSimptomPregled)r.get_case().getDescription()).getId());
				novi.setSimptomi(((CBRModelPregled)r.get_case().getDescription()).getSimptom());
				rezultati.add(novi);
			}else {
				System.out.println("Nothing matches!");
			}
		}
		
		return rezultati;
	}
	
	public List<TestDTO> getTestMatches(CBRModelTest cbr){
		CBRApplicationTest app = new CBRApplicationTest(repo.findAll());
		
		Collection<RetrievalResult> eval = app.evaluate(cbr);
		eval = SelectCases.selectTopKRR(eval, 5);
		
		Set<String> uniqueSetOfTest = new HashSet<>();
		ArrayList<CBRTestDTO> rezultati = new ArrayList<>();
		List<TestDTO> tests = new ArrayList<>();
		
		for(RetrievalResult r : eval) {
			if(r.getEval() > 0) {
				CBRTestDTO novi = new CBRTestDTO();
				novi.setTestovi(((CBRModelTest)r.get_case().getDescription()).getTestovi());
				rezultati.add(novi);
			}else {
				System.out.println("Nothing matches!");
			}
		}
		
		for(CBRTestDTO testDTO : rezultati) {
			for(String test : testDTO.getTestovi()) {
				if(!uniqueSetOfTest.contains(test)) {
					uniqueSetOfTest.add(test);
				}
			}
		}
		//Isfiltrirani testovi
		for(String s : uniqueSetOfTest) {
			TestDTO newTest = new TestDTO(s);
			tests.add(newTest);
		}
		
		return tests;
	}
	
	public List<LekDTO> getLekMatches(CBRModelLek cbr){
CBRApplicationLek app = new CBRApplicationLek(repo.findAll());
		
		Collection<RetrievalResult> eval = app.evaluate(cbr);
		eval = SelectCases.selectTopKRR(eval, 5);
		
		Set<String> uniqueSetOfLek = new HashSet<>();
		ArrayList<CBRLekDTO> rezultati = new ArrayList<>();
		List<LekDTO> lekovi = new ArrayList<>();
		
		for(RetrievalResult r : eval) {
			if(r.getEval() > 0) {
				CBRLekDTO novi = new CBRLekDTO();
				novi.setLekovi(((CBRModelLek)r.get_case().getDescription()).getLekovi());
				rezultati.add(novi);
			}else {
				System.out.println("Nothing matches!");
			}
		}
		
		for(CBRLekDTO lekDTO : rezultati) {
			for(String lek : lekDTO.getLekovi()) {
				if(!uniqueSetOfLek.contains(lek)) {
					uniqueSetOfLek.add(lek);
				}
			}
		}
		//Isfiltrirani lekovi
		for(String s : uniqueSetOfLek) {
			LekDTO newLek = new LekDTO(s);
			lekovi.add(newLek);
		}
		
		return lekovi;
	}
	
	
	public List<DijagnozaDTO> getDijagnozaMatches(CBRModelDijagnoza cbr){
		CBRApplicationDijagnoza app = new CBRApplicationDijagnoza(repo.findAll());
		
		System.out.println("Usao je u finkciju CBRService.getDijagnoza matches!");
		
		Collection<RetrievalResult> eval = app.evaluate(cbr);
		eval = SelectCases.selectTopKRR(eval,4);
		
		if(eval.size() < 1) {
			System.out.println("Eval je prazan;");
		}
		
		Set<String> uniqueSetOfDijagnoze = new HashSet<>();
		ArrayList<CBRDijagnozaDTO> rezultati = new ArrayList<>();
		List<DijagnozaDTO> listaDijagnoza = new ArrayList<>();
		
		for(RetrievalResult r : eval) {
			System.out.println("for petlja");
			if(r.getEval() > 0) {
				System.out.println("if petlja");
				CBRDijagnozaDTO novi = new CBRDijagnozaDTO();
				novi.setDijagnoze(((CBRModelDijagnoza)r.get_case().getDescription()).getDijagnoze());
				rezultati.add(novi);
			}else {
				System.out.println("Nothing matches!");
				
				System.out.println("Dijagnoza!");
			}
		}
		
		for(CBRDijagnozaDTO dijagnozaDTO : rezultati) {
			for(String dijagnoza : dijagnozaDTO.getDijagnoze()) {
				if(!uniqueSetOfDijagnoze.contains(dijagnoza)) {
					uniqueSetOfDijagnoze.add(dijagnoza);
				}
			}
		}
		//Isfiltrirane dijagnoze
		for(String s : uniqueSetOfDijagnoze) {
			DijagnozaDTO newDijagnoza = new DijagnozaDTO(s);
			listaDijagnoza.add(newDijagnoza);
		}
		return listaDijagnoza;
	}
}
