package com.exprivia.scaladivalutazione.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exprivia.scaladivalutazione.Repository.Scl_modelAnswerRepository;
import com.exprivia.scaladivalutazione.Repository.Scl_modelGroupingRepository;
import com.exprivia.scaladivalutazione.Repository.Scl_modelQuestionRepository;
import com.exprivia.scaladivalutazione.Repository.Scl_modelRepository;
import com.exprivia.scaladivalutazione.Repository.Scl_modelVersionRepository;
import com.exprivia.scaladivalutazione.Model.Scl_model;
import com.exprivia.scaladivalutazione.Model.Scl_modelAnswer;
import com.exprivia.scaladivalutazione.Model.Scl_modelGrouping;
import com.exprivia.scaladivalutazione.Model.Scl_modelQuestion;
import com.exprivia.scaladivalutazione.Model.Scl_modelVersion;
import java.util.Set;
import java.util.HashSet;
//defining the business logic  
@Service  
public class Scl_modelService   
{  
	@Autowired  
	Scl_modelRepository scl_modelRepository;
	
	@Autowired  
	Scl_modelAnswerRepository scl_modelAnswerRepository;
	
	@Autowired  
	Scl_modelQuestionRepository scl_modelQuestionRepository;
	
	@Autowired
	Scl_modelVersionRepository scl_modelVersionRepository;
	
	@Autowired
	Scl_modelGroupingRepository scl_modelGroupingRepository;
	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Scl_model> getAllScl_model()   
	{  
	List<Scl_model> sclmodel = new ArrayList<Scl_model>();  
	scl_modelRepository.findAll().forEach(books1 -> sclmodel.add(books1));  
	return sclmodel;  
	}
	
	public List<Scl_modelVersion> getAllScl_modelVersion()   
	{  
	List<Scl_modelVersion> sclmodelversion = new ArrayList<Scl_modelVersion>();  
	scl_modelVersionRepository.findAll().forEach(ver -> sclmodelversion.add(ver));  
	return sclmodelversion;  
	}
	
	public List<Scl_modelGrouping> getAllScl_modelGrouping()   
	{  
	List<Scl_modelGrouping> sclmodelgrouping = new ArrayList<Scl_modelGrouping>();  
	scl_modelGroupingRepository.findAll().forEach(ver2 -> sclmodelgrouping.add(ver2));  
	return sclmodelgrouping;  
	}
	
	public List<Scl_modelQuestion> getAllScl_modelQuestion()   
	{  
	List<Scl_modelQuestion> sclmodelquestion = new ArrayList<Scl_modelQuestion>();  
	scl_modelQuestionRepository.findAll().forEach(ver3 -> sclmodelquestion.add(ver3));  
	return sclmodelquestion;  
	}
	
	public List<Scl_modelAnswer> getAllScl_modelAnswer()   
	{  
	List<Scl_modelAnswer> sclmodelanswer = new ArrayList<Scl_modelAnswer>();  
	scl_modelAnswerRepository.findAll().forEach(ver4 -> sclmodelanswer.add(ver4));  
	return sclmodelanswer;  
	}
	
	public List<Scl_model> finddomande() {
		return scl_modelRepository.finddomande2();
	}  
	
	public List<Scl_modelVersion> prova() {
		return scl_modelRepository.prova2();
	}
	
	public List<Scl_modelGrouping> prova3() {
		return scl_modelRepository.prova4();
	}
	
	//getting a specific record by using the method findById() of CrudRepository  
	public Scl_model getScl_modelById(int id)   
	{  
		return scl_modelRepository.findById(id).get();  
	}
	
	public List<Scl_modelVersion> getScl_modelVersionByIdModel(int id) //list   
	{  
		return scl_modelVersionRepository.getScl_modelVersionbyIDmodel(id);
	}
	public Scl_modelVersion getScl_modelVersionbyIDSinglemodel(int id) //NO list   
	{  
		List<Scl_modelVersion> lista = scl_modelVersionRepository.getScl_modelVersionbyIDmodel(id);
		if(lista.isEmpty())
		{
			return null;
		}
		else
		{
			return lista.get(lista.size()-1);
		}
	}
	
	public Scl_modelGrouping getScl_modelGroupingByIdSingle(int id)   
	{  
		return scl_modelGroupingRepository.getScl_modelGroupingbyIDSinglemodel(id);
	}  
	public List<Scl_modelGrouping> getScl_modelGroupingById(int id)   
	{  
		return scl_modelGroupingRepository.getScl_modelGroupingbyIDmodel(id);
	}  
	
	public Scl_modelQuestion getScl_modelQuestionByIdSingle(int id)   
	{  
		return scl_modelQuestionRepository.getScl_modelQuestionbyIDSingle(id);  
	} 
	public List<Scl_modelQuestion> getScl_modelQuestionById(int id)   
	{  
		return scl_modelQuestionRepository.getScl_modelQuestionbyIDmodel(id);  
	} 
	
	public Scl_modelAnswer getScl_modelAnswerByIdSingle(int id)   
	{  
		return scl_modelAnswerRepository.getScl_modelAnswerbyIDSingle(id);  
	} 
	public List<Scl_modelAnswer> getScl_modelAnswerById(int id)   
	{  
		return scl_modelAnswerRepository.getScl_modelAnswerbyIDquestion(id);  
	} 
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Scl_model scl_model)   
	{  
		scl_modelRepository.save(scl_model);
		//Scl_model nuovomodello = new Scl_model();
		//nuovomodello = scl_model; //altrimenti copia ricorsiva di ogni attributo, nuovomodello.set(scl_model.get)
	}
	public void saveOrUpdateVersion(Scl_modelVersion scl_modelversion)   
	{  
		scl_modelVersionRepository.save(scl_modelversion);
		/*if(scl_modelVersionRepository.getScl_modelVersionbyIDSinglemodel(sm_id) != null)
		{
			for()
		}*/
		
		
		
	}
	
	public Integer deleteGrouping(int id)
	{
		Scl_modelGrouping vecchiogruppo = getScl_modelGroupingByIdSingle(id);
		Scl_modelVersion vecchiaversione = vecchiogruppo.getModelVersion();
		Scl_modelVersion nuovaversione = new Scl_modelVersion();
		nuovaversione.setScoringLabel(vecchiaversione.getScoringLabel());
		nuovaversione.setScoringFormula(vecchiaversione.getScoringFormula());
		nuovaversione.setVersion(vecchiaversione.getVersion()+1);	//incremento la versione
		nuovaversione.setCreationDate(vecchiaversione.getCreationDate());	//TO DO: inserire funzione che mette la data attuale
		nuovaversione.setlastModificationUser(vecchiaversione.getlastModificationUser());
		nuovaversione.setModel(vecchiaversione.getModel());
		
		saveOrUpdateVersion(nuovaversione);
		
		//copia della version
		for(Scl_modelGrouping gruppo: getScl_modelGroupingById(vecchiaversione.getId()))
		{	
			if(gruppo.getId() == id)
			{
				continue;
			}
			Scl_modelGrouping nuovogruppo = new Scl_modelGrouping();
			nuovogruppo.setDescription(gruppo.getDescription());
			nuovogruppo.setHeader(gruppo.getHeader());
			nuovogruppo.setPosition(gruppo.getPosition());
			nuovogruppo.setScoringLabel(gruppo.getScoringLabel());
			nuovogruppo.setShowScoring(gruppo.getShowScoring());
			nuovogruppo.setModelVersion(nuovaversione);
			
			saveOrUpdateGrouping(nuovogruppo);
			
			for(Scl_modelQuestion domanda: getScl_modelQuestionById(gruppo.getId()))
			{
				Scl_modelQuestion nuovadomanda = new Scl_modelQuestion();
				nuovadomanda.setHeader(domanda.getHeader());
				nuovadomanda.setPosition(domanda.getPosition());
				//nuovadomanda.setClassField(domanda.getClassField());
				//nuovadomanda.setRegexErrorDescription(domanda.getRegexErrorDescription());
				//nuovadomanda.setRegexExpr(domanda.getRegexExpr());
				nuovadomanda.setRenderAnswers(domanda.getRenderAnswers());
				nuovadomanda.setText(domanda.getText());
				nuovadomanda.setModelGrouping(nuovogruppo);
				
				saveOrUpdateQuestion(nuovadomanda);
				
				for(Scl_modelAnswer risposta: getScl_modelAnswerById(domanda.getId()))
				{
					Scl_modelAnswer nuovarisposta = new Scl_modelAnswer();
					nuovarisposta.setImage(risposta.getImage());
					nuovarisposta.setPosition(risposta.getPosition());
					nuovarisposta.setScore(risposta.getScore());
					nuovarisposta.setText(risposta.getText());
					nuovarisposta.setModelQuestion(nuovadomanda);
					
					saveOrUpdateAnswer(nuovarisposta);
				}
			}
		}
		
		return nuovaversione.getId();
	}
	
	public Integer deleteQuestion(int id)
	{
		Scl_modelQuestion vecchiadomanda = getScl_modelQuestionByIdSingle(id);
		
		//System.out.println("nuovaversione");
		Scl_modelGrouping vecchiogruppo = vecchiadomanda.getModelGrouping();
		System.out.println(vecchiogruppo);
		Scl_modelVersion vecchiaversione = vecchiogruppo.getModelVersion(); //PROBLEMA
		//System.out.println("2");
		Scl_modelVersion nuovaversione = new Scl_modelVersion();
		//System.out.println("3");
		nuovaversione.setScoringLabel(vecchiaversione.getScoringLabel());
		//System.out.println("4");
		nuovaversione.setScoringFormula(vecchiaversione.getScoringFormula());
		nuovaversione.setVersion(vecchiaversione.getVersion()+1);	//incremento la versione
		nuovaversione.setCreationDate(vecchiaversione.getCreationDate());	//TO DO: inserire funzione che mette la data attuale
		nuovaversione.setlastModificationUser(vecchiaversione.getlastModificationUser());
		nuovaversione.setModel(vecchiaversione.getModel());
		
		//System.out.println("nuovaversione2");
		saveOrUpdateVersion(nuovaversione);
		//System.out.println("nuovaversione3");
		
		//copia della version
		for(Scl_modelGrouping gruppo: getScl_modelGroupingById(vecchiaversione.getId()))
		{	
			
			Scl_modelGrouping nuovogruppo = new Scl_modelGrouping();
			nuovogruppo.setDescription(gruppo.getDescription());
			nuovogruppo.setHeader(gruppo.getHeader());
			nuovogruppo.setPosition(gruppo.getPosition());
			nuovogruppo.setScoringLabel(gruppo.getScoringLabel());
			nuovogruppo.setShowScoring(gruppo.getShowScoring());
			nuovogruppo.setModelVersion(nuovaversione);
			
			saveOrUpdateGrouping(nuovogruppo);
			
			for(Scl_modelQuestion domanda: getScl_modelQuestionById(gruppo.getId()))
			{
				if(domanda.getId() == id)
				{
					continue;
				}
				Scl_modelQuestion nuovadomanda = new Scl_modelQuestion();
				nuovadomanda.setHeader(domanda.getHeader());
				nuovadomanda.setPosition(domanda.getPosition());
				//nuovadomanda.setClassField(domanda.getClassField());
				//nuovadomanda.setRegexErrorDescription(domanda.getRegexErrorDescription());
				//nuovadomanda.setRegexExpr(domanda.getRegexExpr());
				nuovadomanda.setRenderAnswers(domanda.getRenderAnswers());
				nuovadomanda.setText(domanda.getText());
				nuovadomanda.setModelGrouping(nuovogruppo);
				
				saveOrUpdateQuestion(nuovadomanda);
				
				for(Scl_modelAnswer risposta: getScl_modelAnswerById(domanda.getId()))
				{
					Scl_modelAnswer nuovarisposta = new Scl_modelAnswer();
					nuovarisposta.setImage(risposta.getImage());
					nuovarisposta.setPosition(risposta.getPosition());
					nuovarisposta.setScore(risposta.getScore());
					nuovarisposta.setText(risposta.getText());
					nuovarisposta.setModelQuestion(nuovadomanda);
					
					saveOrUpdateAnswer(nuovarisposta);
				}
			}
		}
		
		return nuovaversione.getId();
	}
	
	public Integer deleteAnswer(int id)
	{
		Scl_modelAnswer vecchiarisposta = getScl_modelAnswerByIdSingle(id);
		Scl_modelQuestion vecchiadomanda = vecchiarisposta.getModelQuestion();
		Scl_modelGrouping vecchiogruppo = vecchiadomanda.getModelGrouping();
		
		Scl_modelVersion vecchiaversione = vecchiogruppo.getModelVersion();
		Scl_modelVersion nuovaversione = new Scl_modelVersion();
		nuovaversione.setScoringLabel(vecchiaversione.getScoringLabel());
		nuovaversione.setScoringFormula(vecchiaversione.getScoringFormula());
		nuovaversione.setVersion(vecchiaversione.getVersion()+1);	//incremento la versione
		nuovaversione.setCreationDate(vecchiaversione.getCreationDate());	//TO DO: inserire funzione che mette la data attuale
		nuovaversione.setlastModificationUser(vecchiaversione.getlastModificationUser());
		nuovaversione.setModel(vecchiaversione.getModel());
		
		saveOrUpdateVersion(nuovaversione);
		
		//copia della version
		for(Scl_modelGrouping gruppo: getScl_modelGroupingById(vecchiaversione.getId()))
		{	
			Scl_modelGrouping nuovogruppo = new Scl_modelGrouping();
			nuovogruppo.setDescription(gruppo.getDescription());
			nuovogruppo.setHeader(gruppo.getHeader());
			nuovogruppo.setPosition(gruppo.getPosition());
			nuovogruppo.setScoringLabel(gruppo.getScoringLabel());
			nuovogruppo.setShowScoring(gruppo.getShowScoring());
			nuovogruppo.setModelVersion(nuovaversione);
			
			saveOrUpdateGrouping(nuovogruppo);
			
			for(Scl_modelQuestion domanda: getScl_modelQuestionById(gruppo.getId()))
			{
				Scl_modelQuestion nuovadomanda = new Scl_modelQuestion();
				nuovadomanda.setHeader(domanda.getHeader());
				nuovadomanda.setPosition(domanda.getPosition());
				//nuovadomanda.setClassField(domanda.getClassField());
				//nuovadomanda.setRegexErrorDescription(domanda.getRegexErrorDescription());
				//nuovadomanda.setRegexExpr(domanda.getRegexExpr());
				nuovadomanda.setRenderAnswers(domanda.getRenderAnswers());
				nuovadomanda.setText(domanda.getText());
				nuovadomanda.setModelGrouping(nuovogruppo);
				
				saveOrUpdateQuestion(nuovadomanda);
				
				for(Scl_modelAnswer risposta: getScl_modelAnswerById(domanda.getId()))
				{
					if(risposta.getId() == id)
					{
						continue;
					}
					Scl_modelAnswer nuovarisposta = new Scl_modelAnswer();
					nuovarisposta.setImage(risposta.getImage());
					nuovarisposta.setPosition(risposta.getPosition());
					nuovarisposta.setScore(risposta.getScore());
					nuovarisposta.setText(risposta.getText());
					nuovarisposta.setModelQuestion(nuovadomanda);
					
					saveOrUpdateAnswer(nuovarisposta);
				}
			}
		}
		
		return nuovaversione.getId();
	}
	
	public void saveOrUpdateGrouping(Scl_modelGrouping scl_modelgrouping)   
	{  
		scl_modelGroupingRepository.save(scl_modelgrouping);  
	}
	public void saveOrUpdateQuestion(Scl_modelQuestion scl_modelquestion)   
	{  
		scl_modelQuestionRepository.save(scl_modelquestion);  
	}
	public void saveOrUpdateAnswer(Scl_modelAnswer scl_modelanswer)   
	{  
		scl_modelAnswerRepository.save(scl_modelanswer);  
	}
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		scl_modelRepository.deleteById(id);  
	}  
	
	/*public void deleteQuestion(int id)   
	{  
		scl_modelQuestionRepository.deleteById(id);  
	}*/
	//updating a record  
	public void update(Scl_model scl_model, int sm_id)   
	{  
		scl_modelRepository.save(scl_model);  
	}

	public void save(Scl_model scl_model) {
		scl_modelRepository.save(scl_model);
	}
	
	
}  