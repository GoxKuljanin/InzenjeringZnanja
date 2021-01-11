package com.klinika.pregled.cbrApplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.klinika.pregled.model.Dijagnoza;
import com.klinika.pregled.model.Pregled;
import com.klinika.pregled.model.Simptom;
import com.klinika.pregled.model.Test;

import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;

public class CsvConnectorDijagnoza implements Connector {

//    private List<Dijagnoza> dijagnoze = new ArrayList<Dijagnoza>();
    
    private List<Pregled> pregledi = new ArrayList<Pregled>();

    public CsvConnectorDijagnoza(List<Pregled> pregledi) {
        // TODO Auto-generated constructor stub
        this.pregledi = pregledi;
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
        // TODO Auto-generated method stub
        LinkedList<CBRCase> cases = new LinkedList<CBRCase>();

        List<CBRModelDijagnoza> modelDijagnoze = new ArrayList<>();
        
        for(Pregled p : this.pregledi) {
			CBRModelDijagnoza modelDijagnoza = new CBRModelDijagnoza();
			
			Set<String> dijagnoze = new HashSet<>();
			for(Dijagnoza d : p.getDijagnoze()) {
				dijagnoze.add(d.getName());
			}
			modelDijagnoza.setDijagnoze(dijagnoze); //setTest(t.getName());
			for(Test t : p.getTestovi()) {
				modelDijagnoza.getTestovi().add(t.getName());
			}
			CBRCase cbrCase = new CBRCase();
			cbrCase.setDescription(modelDijagnoza);
			cases.add(cbrCase);
		}
       

        return cases;
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
