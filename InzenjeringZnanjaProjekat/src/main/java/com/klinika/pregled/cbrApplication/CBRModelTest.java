package com.klinika.pregled.cbrApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class CBRModelTest implements CaseComponent{

	private Set<String> testovi = new HashSet<>();
	private List<String> simptomi = new ArrayList<String>();
	
	private int brojgodina;
	private int tezina;
	private String pol;		//Format : m / f;
	private String rasa; 	//Format : white / black / other;
	
	@Override
	public Attribute getIdAttribute() {
		return null;
	}
	
	public CBRModelTest() {
		super();
	}
	
	public List<String> getSimptomi() {
		return simptomi;
	}
	public void setSimptomi(List<String> simptomi) {
		this.simptomi = simptomi;
	}
	
	
	public Set<String> getTestovi() {
		return testovi;
	}

	public void setTestovi(Set<String> testovi) {
		this.testovi = testovi;
	}

	@Override
	public String toString() {
		return "CBRModelTest [testovi=" + testovi + ", simptomi=" + simptomi + "]";
	}

	public int getBrojgodina() {
		return brojgodina;
	}

	public void setBrojgodina(int brojgodina) {
		this.brojgodina = brojgodina;
	}

	public int getTezina() {
		return tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getRasa() {
		return rasa;
	}

	public void setRasa(String rasa) {
		this.rasa = rasa;
	}
	
	
}
