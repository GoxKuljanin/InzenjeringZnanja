package com.klinika.pregled.cbrApplication;

import java.util.ArrayList;
import java.util.List;

import ucm.gaia.jcolibri.exception.NoApplicableSimilarityFunctionException;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;

public class TableSimilarity implements LocalSimilarityFunction {
	
	public static int brojac;

	private double matrix[][];
	List<String> categories;
	
	List<List<String>> stringMatrix;
	
	public TableSimilarity() {
		super();
		brojac = 0;
	}
	
	public TableSimilarity(List<String> categories) {
		this.categories = categories;
		int n = categories.size();
		matrix = new double[n][n];
		for (int i=0; i<n; i++)
			matrix[i][i] = 1;  // symbolic similarity of term with itself
	}
	
	public void setSimilarity(String value1, String value2, double sim) {
		setSimilarity(value1, value2, sim, sim);
	}
	
	public void setSimilarity(String value1, String value2, double sim1, double sim2) {
		int index1 = categories.indexOf(value1);
		int index2 = categories.indexOf(value2);
		if (index1 != -1 && index2 != -1) {
			matrix[index1][index2] = sim1;
			matrix[index2][index1] = sim2;
		}
	}
	
	@Override
	public double compute(Object value1, Object value2) throws NoApplicableSimilarityFunctionException {
		
		System.out.println(((List<String>)value1));
		
		System.out.println("Value1: " + value1 + " value2 " + value2);
//		int index1 = categories.indexOf(value1);
//		int index2 = categories.indexOf(value2);
//		if (index1 != -1 && index2 != -1)
//			return matrix[index1][index2];
//		if (value1 != null && value1.equals(value2))
//			return 1;
		//System.out.println("compute!" + value1.toString() + " " + value2.toString());
		
		double sim = 0;
		
		List<String> listaSimptomaTebele = ((List<String>)value2);
		for(String s2 : (List<String>)value2) {
			for(String s1 : (List<String>)value1) {
				if(s1.equals(s2)) {
					System.out.println(s2);
					sim +=1 ;
				}
			}
		}
		
//		if(((List<String>)value2).contains(value1)) {
//			return 1;
//		}
		return sim/(((List<String>)value2).size());
	}

	@Override
	public boolean isApplicable(Object value1, Object value2) {
		//if (value1 instanceof String && value2 instanceof String)
		System.out.println("aplicable!" + value1.toString() + " " + value2.toString());
			return true;
		//return false;
	}

	


	
	
}
