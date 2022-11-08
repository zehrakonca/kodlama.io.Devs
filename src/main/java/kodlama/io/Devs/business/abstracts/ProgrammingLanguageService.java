package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.languageRequests.CreateProgrammingLanguageRequests;
import kodlama.io.Devs.business.requests.languageRequests.UpdateProgrammingLanguageRequests;
import kodlama.io.Devs.business.responses.languageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	void add(CreateProgrammingLanguageRequests createRequests) throws Exception;
	void delete(int id);
	void update(UpdateProgrammingLanguageRequests updateProgrammingLanguageRequests, int id) throws Exception;
	
	List<GetAllProgrammingLanguageResponse> getAll();
	
	public ProgrammingLanguage getById(int id);
	public ProgrammingLanguage getByResponseId(int id);
	
}
