package com.exprivia.scaladivalutazione.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exprivia.scaladivalutazione.Exception.ResourceNotFoundException;
import com.exprivia.scaladivalutazione.Model.Scl_model;
import com.exprivia.scaladivalutazione.Model.Scl_modelAnswer;
import com.exprivia.scaladivalutazione.Model.Scl_modelAnswerDTO;
import com.exprivia.scaladivalutazione.Model.Scl_modelGrouping;
import com.exprivia.scaladivalutazione.Model.Scl_modelGroupingDTO;
import com.exprivia.scaladivalutazione.Model.Scl_modelQuestion;
import com.exprivia.scaladivalutazione.Model.Scl_modelQuestionDTO;
import com.exprivia.scaladivalutazione.Model.Scl_modelVersion;
import com.exprivia.scaladivalutazione.Model.Scl_modelVersionDTO;
import com.exprivia.scaladivalutazione.service.Scl_modelService;

//mark class as Controller  
@RestController  
public class Scl_modelController   
{  
	// autowire the BooksService class  
	@Autowired  
	Scl_modelService scl_modelservice;
	
	//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping("/scl_model")  
	private List<Scl_model> getAllSclModel()   
	{  
		return scl_modelservice.getAllScl_model();  
	}  
	
	@GetMapping("/scl_modelVersion")  
	private List<Scl_modelVersion> getAllSclModelVersion()   
	{  
		return scl_modelservice.getAllScl_modelVersion();  
	}
	
	@GetMapping("/scl_modelGrouping")  
	private List<Scl_modelGrouping> getAllSclModelGrouping()   
	{  
		return scl_modelservice.getAllScl_modelGrouping();  
	}
	
	@GetMapping("/scl_modelQuestion")  
	private List<Scl_modelQuestion> getAllSclModelQuestion()   
	{  
		return scl_modelservice.getAllScl_modelQuestion();  
	}
	
	@GetMapping("/scl_modelAnswer")  
	private List<Scl_modelAnswer> getAllSclModelAnswer()   
	{  
		return scl_modelservice.getAllScl_modelAnswer();  
	}
	
	/*@GetMapping("/domande")  
	private List<Scl_model> getAllDomande()   
	{  
		return scl_modelservice.finddomande();  
	}*/
	
	/*@GetMapping("/allversion")  
	private List<Scl_modelVersion> getAllDomandeprova()   
	{  
		return scl_modelservice.prova();  
	}*/
	
	
	//creating a get mapping that retrieves the detail of a specific  
	@GetMapping("/scl_model/{sm_id}")  
	private Scl_model getSclModel(@PathVariable("sm_id") int sm_id)   
	{  
		return scl_modelservice.getScl_modelById(sm_id);  
	}
	
	@GetMapping("/scl_modelVersions/{sm_id}")  
	private List<Scl_modelVersion> getSclModelVersion(@PathVariable("sm_id") int sm_id)   
	{  
		return scl_modelservice.getScl_modelVersionByIdModel(sm_id);  
	}
	@GetMapping("/scl_modelVersion/{sm_id}")  
	private Scl_modelVersion getSclModelVersionSingle(@PathVariable("sm_id") int sm_id)   
	{  
		return scl_modelservice.getScl_modelVersionbyIDSinglemodel(sm_id);  
	}
	
	@GetMapping("/scl_modelGrouping/{sv_id}")  
	private List<Scl_modelGrouping> getSclModelGrouping(@PathVariable("sv_id") int sv_id)   
	{  
		return scl_modelservice.getScl_modelGroupingById(sv_id);  
	}
	
	@GetMapping("/scl_modelQuestion/{sg_id}")  
	private List<Scl_modelQuestion> getSclModelQuestion(@PathVariable("sg_id") int sg_id)   
	{  
		return scl_modelservice.getScl_modelQuestionById(sg_id);  
	}
	
	
	@GetMapping("/scl_modelAnswer/{sq_id}")  
	private List<Scl_modelAnswer> getSclModelAnswer(@PathVariable("sq_id") int sq_id)   
	{  
		return scl_modelservice.getScl_modelAnswerById(sq_id);  
	}
	
	//creating a delete mapping that deletes a specified model  
	@DeleteMapping("/scl_model/{sm_id}")  	//cancella i modelli
	private void deleteBook(@PathVariable("sm_id") int sm_id)   
	{  
		scl_modelservice.delete(sm_id);  
	}
	
	@CrossOrigin
	@DeleteMapping("/scl_modelGrouping/{sg_id}")  
	private Integer deleteGrouping(@PathVariable("sg_id") int sg_id)   
	{  
		return scl_modelservice.deleteGrouping(sg_id);  
	}
	
	@CrossOrigin
	@DeleteMapping("/scl_modelAnswer/{sa_id}")  
	private Integer deleteAnswer(@PathVariable("sa_id") int sa_id)   
	{  
		return scl_modelservice.deleteAnswer(sa_id);  
	}
	
	@CrossOrigin
	@DeleteMapping("/scl_modelQuestion/{sq_id}")  //sq_id è null FORSE
	private Integer deleteQuestion(@PathVariable("sq_id") int sq_id)   
	{  
		System.out.println("ciao");
		return scl_modelservice.deleteQuestion(sq_id);  
	}  
	
	//creating post mapping that post the book detail in the database  
	@CrossOrigin //importante, ricorda
	@PostMapping("/scl_model")  
	private int saveScl_model(@RequestBody Scl_model scl_model)   
	{  
		scl_modelservice.saveOrUpdate(scl_model);  
		return scl_model.getSm_id();  
	}  
	
	@CrossOrigin //importante, ricorda
	@PostMapping("/scl_modelVersion/{i}")  
	private int saveScl_modelVersion(@RequestBody Scl_modelVersionDTO request, @PathVariable int i)   //risolvi qui
	{  
		Scl_modelVersion scl_modelVersion = Scl_modelVersion.toScl_modelVersionEntity(request);
		try {
			Scl_model scl_model =  scl_modelservice.getScl_modelById((int) i);
			scl_modelVersion.setModel(scl_model);
			scl_modelservice.saveOrUpdateVersion(scl_modelVersion);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		  
		return scl_modelVersion.getId();
	}

	@CrossOrigin //importante, ricorda
	@PostMapping("/scl_modelGrouping/{i}")  
	private int saveScl_modelGrouping(@RequestBody Scl_modelGroupingDTO request, @PathVariable int i)   //risolvi qui
	{  
		Scl_modelGrouping scl_modelGrouping = Scl_modelGrouping.toScl_modelGroupingEntity(request);
		try {
			Scl_modelVersion scl_modelVersion =  scl_modelservice.getScl_modelVersionbyIDSinglemodel((int) i);
			scl_modelGrouping.setModelVersion(scl_modelVersion);
			scl_modelservice.saveOrUpdateGrouping(scl_modelGrouping);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		  
		return scl_modelGrouping.getId();
	}
	
	//errore: no such element exception
	@CrossOrigin //importante, ricorda
	@PostMapping("/scl_modelQuestion/{i}")  
	private int saveScl_modelQuestion(@RequestBody Scl_modelQuestionDTO request, @PathVariable int i)   //risolvi qui
	{  
		Scl_modelQuestion scl_modelQuestion = Scl_modelQuestion.toScl_modelQuestionEntity(request);
		try {
			Scl_modelGrouping scl_modelGrouping =  scl_modelservice.getScl_modelGroupingByIdSingle((int) i);
			scl_modelQuestion.setModelGrouping(scl_modelGrouping);
			scl_modelservice.saveOrUpdateQuestion(scl_modelQuestion);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		  
		return scl_modelQuestion.getId();
	}
	
	//errore (da sistemare come sopra)
	@CrossOrigin //importante, ricorda
	@PostMapping("/scl_modelAnswer/{i}")  
	private int saveScl_modelAnswer(@RequestBody Scl_modelAnswerDTO request, @PathVariable int i)   //risolvi qui
	{  
		Scl_modelAnswer scl_modelAnswer = Scl_modelAnswer.toScl_modelAnswerEntity(request);
		try {
			Scl_modelQuestion scl_modelQuestion =  scl_modelservice.getScl_modelQuestionByIdSingle((int) i);
			scl_modelAnswer.setModelQuestion(scl_modelQuestion);
			scl_modelservice.saveOrUpdateAnswer(scl_modelAnswer);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		  
		return scl_modelAnswer.getId();
	}
	
	//save
	/*@PostMapping("/scl_model")  
	private Scl_model save(@RequestBody Scl_model scl_model)   
	{  
		scl_modelservice.saveOrUpdate(scl_model);  
		return scl_model;  
	}*/
	
	//creating put mapping that updates the book detail   
	@PutMapping("/scl_model")  
	private Scl_model update(@RequestBody Scl_model scl_model)   
	{  
		scl_modelservice.saveOrUpdate(scl_model);  
		return scl_model;  
	}
}  
