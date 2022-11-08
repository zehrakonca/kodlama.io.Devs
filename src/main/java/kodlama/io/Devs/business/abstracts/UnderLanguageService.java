package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.languageRequests.UpdateProgrammingLanguageRequests;
import kodlama.io.Devs.business.requests.underLanguageRequests.CreateUnderLanguageRequest;
import kodlama.io.Devs.business.responses.underLanguageResponses.GetAllUnderLanguageResponse;
import kodlama.io.Devs.entities.concretes.UnderLanguage;

public interface UnderLanguageService {
	
	void add(CreateUnderLanguageRequest createUnderLanguageRequest) throws Exception;
	void delete(int id);
	void update(UpdateProgrammingLanguageRequests updateProgrammingLanguageRequests,int id) throws Exception;
	
	List<GetAllUnderLanguageResponse> getAll();
	
	public UnderLanguage getById(int id);
	
}
