package com.klinika.pregled.cbrApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class CBRModelDijagnoza implements CaseComponent{

    //private List<Test> testovi = new ArrayList<Test>();
    private Set<String> dijagnoze = new HashSet<>();
    private List<String> testovi = new ArrayList<String>();

    @Override
    public Attribute getIdAttribute() {
        // TODO Auto-generated method stub
        return null;
    }
    public CBRModelDijagnoza() {
        super();
    }
    public List<String> getTestovi() {
        return testovi;
    }
    public void setTestovi(List<String> testovi) {
        this.testovi = testovi;
    }
    
//    public void setTestovi2(List<CBRTestDTO> testovi) {
//        for(CBRTestDTO test : testovi) {
//        	this.testovi.set(test.getTestovi());
//        }
//    }
    
    @Override
    public String toString() {
        return "CBRModelDijagnoza [dijagnoze=" + dijagnoze + ", testovi=" + testovi + "]";
    }
    /*public String getDijagnoza() {
        return dijagnoza;
    }
    public void setDijagnoza(String dijagnoza) {
        this.dijagnoza = dijagnoza;
    }*/
	public Set<String> getDijagnoze() {
		return dijagnoze;
	}
	public void setDijagnoze(Set<String> dijagnoze) {
		this.dijagnoze = dijagnoze;
	}
    
    

}
