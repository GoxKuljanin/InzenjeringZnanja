package com.klinika.pregled.dto;

import java.util.HashSet;
import java.util.Set;

public class CBRDijagnozaListaDTO {
	
	private Set<String> dijagnoze = new HashSet<>();
	
	
	public CBRDijagnozaListaDTO() {
		super();
	}

	public CBRDijagnozaListaDTO(Set<String> dijagnoze) {
		super();
		this.dijagnoze = dijagnoze;
	}

	public Set<String> getDijagnoze() {
		return dijagnoze;
	}

	public void setDijagnoze(Set<String> dijagnoze) {
		this.dijagnoze = dijagnoze;
	}
	
	
	
	
	@Override
	public String toString() {
		return "CBRDijagnozaListaDTO [dijagnoze=" + dijagnoze + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dijagnoze == null) ? 0 : dijagnoze.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CBRDijagnozaListaDTO other = (CBRDijagnozaListaDTO) obj;
		if (dijagnoze == null) {
			if (other.dijagnoze != null)
				return false;
		} else if (!dijagnoze.equals(other.dijagnoze))
			return false;
		return true;
	}
	
	
	
}
