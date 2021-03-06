package com.klinika.pregled.cbrApplication;

import java.util.Collection;
import java.util.List;

import com.klinika.pregled.model.Pregled;

import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class CbrApplication implements StandardCBRApplication{

	public List<Pregled> pregledi;
	Connector _connector;
	CBRCaseBase _caseBase;
	static Collection<RetrievalResult> requestResults;
	NNConfig simConfig;
	
	public CbrApplication(List<Pregled> pregleds) {
		// TODO Auto-generated constructor stub
		super();
		this.pregledi = pregleds;
		try {
            this.configure();
            this.preCycle();
        } catch(ExecutionException e) {
            e.printStackTrace();
            System.out.println("Greska u cbrapp klasi");
        }
	}
	
	@Override
	public void configure() throws ExecutionException {
		// TODO Auto-generated method stub
		_connector = new CsvConnector(pregledi);
		_caseBase = new LinealCaseBase();
		
		simConfig = new NNConfig();
		simConfig.setDescriptionSimFunction(new Average());
		
		simConfig.addMapping(new Attribute("simptom", CBRModelPregled.class), new TableSimilarity());
	}

	@Override
	public void cycle(CBRQuery query) throws ExecutionException {
		// TODO Auto-generated method stub
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
        eval = SelectCases.selectTopKRR(eval, 5);
        System.out.println("Retrieved cases: ");
        for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
        requestResults = eval;
	}

	@Override
	public void postCycle() throws ExecutionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CBRCaseBase preCycle() throws ExecutionException {
		// TODO Auto-generated method stub
		_caseBase.init(_connector);
		/*java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for (CBRCase c: cases)
			System.out.println(c.getDescription());*/
        return _caseBase;
	}
	
	public Collection<RetrievalResult> evaluate(CBRModelPregled cbr){
        try {
            CBRQuery query = new CBRQuery();

            query.setDescription(cbr);
            cycle(query);

            return requestResults;

        } catch(Exception e){
            e.printStackTrace();
            return null;

        }





    }

	
}
