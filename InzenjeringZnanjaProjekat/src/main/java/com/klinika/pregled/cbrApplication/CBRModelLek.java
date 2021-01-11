package com.klinika.pregled.cbrApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;


public class CBRModelLek implements CaseComponent{
	
	private Set<String> lekovi = new HashSet<>();
	private List<String> dijagnoze = new ArrayList<String>();

	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CBRModelLek() {
		super();
	}

	public Set<String> getLekovi() {
		return lekovi;
	}

	public void setLekovi(Set<String> lekovi) {
		this.lekovi = lekovi;
	}

	public List<String> getDijagnoze() {
		return dijagnoze;
	}

	public void setDijagnoze(List<String> dijagnoze) {
		this.dijagnoze = dijagnoze;
	}
	
	@Override
	public String toString() {
		return "CBRModelLek [lekovi=" + lekovi + ", dijagnoze=" + dijagnoze + "]";
	}
}
