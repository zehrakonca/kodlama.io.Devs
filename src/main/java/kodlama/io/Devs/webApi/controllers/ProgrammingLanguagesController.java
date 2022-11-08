package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.languageRequests.CreateProgrammingLanguageRequests;
import kodlama.io.Devs.business.requests.languageRequests.UpdateProgrammingLanguageRequests;
import kodlama.io.Devs.business.responses.languageResponses.GetAllProgrammingLanguageResponse;

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
	public List<GetAllProgrammingLanguageResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateProgrammingLanguageRequests createProgrammingLanguageRequests) throws Exception {
		this.programmingLanguageService.add(createProgrammingLanguageRequests);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody() int id) {
		this.programmingLanguageService.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody() UpdateProgrammingLanguageRequests updateProgrammingLanguageRequests, int id) throws Exception{
		this.programmingLanguageService.update(updateProgrammingLanguageRequests, id);
	}
}
