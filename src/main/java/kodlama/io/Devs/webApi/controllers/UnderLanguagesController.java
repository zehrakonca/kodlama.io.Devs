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

import kodlama.io.Devs.business.abstracts.UnderLanguageService;
import kodlama.io.Devs.business.requests.languageRequests.UpdateProgrammingLanguageRequests;
import kodlama.io.Devs.business.requests.underLanguageRequests.CreateUnderLanguageRequest;
import kodlama.io.Devs.business.responses.underLanguageResponses.GetAllUnderLanguageResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/underLanguages")
@RequiredArgsConstructor
public class UnderLanguagesController {
	private UnderLanguageService underLanguageService;

	@Autowired
	public UnderLanguagesController(UnderLanguageService underLanguageService) {
		super();
		this.underLanguageService = underLanguageService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllUnderLanguageResponse> getAll(){
		return this.underLanguageService.getAll();
		}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateUnderLanguageRequest createUnderLanguageRequest) throws Exception {
		this.underLanguageService.add(createUnderLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody() int id) {
		this.underLanguageService.delete(id);
	}
	
	@PutMapping("/update{id}")
	public void update(@RequestBody() UpdateProgrammingLanguageRequests updateProgrammingLanguageRequests, int id) throws Exception {
		this.underLanguageService.update(updateProgrammingLanguageRequests, id);
	}
}
