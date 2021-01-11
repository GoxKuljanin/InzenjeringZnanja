package com.klinika.pregled.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CBRTestDTO {

	private Set<String> testovi = new HashSet<>();
	
	public CBRTestDTO() {
		super();
	}

	

	public Set<String> getTestovi() {
		return testovi;
	}



	public void setTestovi(Set<String> testovi) {
		this.testovi = testovi;
	}



	@Override
	public String toString() {
		return "CBRTestDTO [testovi=" + testovi + "]";
	}

	
}
