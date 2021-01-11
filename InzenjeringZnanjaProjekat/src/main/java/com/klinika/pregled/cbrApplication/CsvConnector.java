package com.klinika.pregled.cbrApplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.klinika.pregled.model.Pregled;
import com.klinika.pregled.model.Simptom;

import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;

public class CsvConnector implements Connector{

	private List<Pregled> pregledi = new ArrayList<Pregled>();

	public CsvConnector(List<Pregled> pregleds) {
		// TODO Auto-generated constructor stub
		this.pregledi = pregleds;
	}
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<CBRCase> retrieveAllCases() {
		/*// TODO Auto-generated method stub
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		List<CBRModelPregled> modeli = new ArrayList<>();
		List<Pregled> obradjeniPregledi = new ArrayList<>();
		
		for(Pregled p : this.pregledi) {
			CBRModelPregled cbrmodel = new CBRModelPregled();
			cbrmodel.setDijagnoza(p.getDijagnoza().getName());
			List<String> listaString = new ArrayList<>();
			for(Simptom s : p.getSimptomi()) {
				cbrmodel.getSimptom().add(s.getName());
			}
			CBRCase newCase = new CBRCase();
			newCase.setDescription(cbrmodel);
			cases.add(newCase);
		}
		
//		for(int i = 0; i < this.pregledi.size(); i++) {
//			Pregled p = this.pregledi.get(i);
//			for(Simptom s : p.getSimptomi()) {
//				CBRModelSimptomPregled cbrm = new CBRModelSimptomPregled();
//				cbrm.setDijagnoza(p.getDijagnoza().getName());
//				cbrm.getSimptom().add(s.getName());
//				//cbrm.setId(p.getId());
//				modeli.add(cbrm);
//			}
////		}
//		for(CBRModelSimptomPregled m : modeli) {
//			CBRCase cbrcase = new CBRCase();
//			cbrcase.setDescription(m);
//			cases.add(cbrcase);
//		}
		return cases;*/
		
		return null;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
		// TODO Auto-generated method stub
		
	}

}
