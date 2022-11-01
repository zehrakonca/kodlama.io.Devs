package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getAll")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
//	@GetMapping("/getById")
//	public ProgrammingLanguage getById(int id){
//		return programmingLanguageService.getById(id);
//	}
//	
//	@GetMapping("/getByName")
//	public ProgrammingLanguage getByName(String language){
//		 return programmingLanguageService.getByLanguage(language);
//	}
	
	@PostMapping("/add")
	    public void add(@RequestBody ProgrammingLanguage language) {
	        programmingLanguageService.add(language);
	    }
	
	@PutMapping("/update")
	    public void update(@RequestParam ProgrammingLanguage language){
		programmingLanguageService.update(language);
	    }
	
	@PostMapping("/delete")
    public void delete(@RequestBody int id) {
		programmingLanguageService.delete(id);
    }
}
