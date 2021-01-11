package com.klinika.pregled.cbrApplication;

import java.util.ArrayList;
import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class CBRModelPregled implements CaseComponent{

	private List<String> simptom = new ArrayList<>();
	private String dijagnoza;
	
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "CBRModelSimptomPregled [simptom=" + simptom + ", dijagnoza=" + dijagnoza + "]";
	}

	public List<String> getSimptom() {
		return simptom;
	}

	public void setSimptom(List<String> simptom) {
		this.simptom = simptom;
	}

	public String getDijagnoza() {
		return dijagnoza;
	}

	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}
}
