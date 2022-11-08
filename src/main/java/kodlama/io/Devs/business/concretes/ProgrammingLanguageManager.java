package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.languageRequests.CreateProgrammingLanguageRequests;
import kodlama.io.Devs.business.requests.languageRequests.UpdateProgrammingLanguageRequests;
import kodlama.io.Devs.business.responses.languageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	boolean isExist = false;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateProgrammingLanguageRequests createRequests) throws Exception{
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setLanguage(createRequests.getLanguage());
		
		if(programmingLanguage.getLanguage()==null || createRequests.getLanguage().isEmpty()) {
			throw new Exception("this area cannot be blank");
		}
		else if(isLanguageExist(createRequests.getLanguage())==true) {
			throw new Exception("this programming language is in list already.");
		}
		else {
			this.programmingLanguageRepository.save(programmingLanguage);
		}
		
	}
	
	@Override
	public void delete(int id) {
		programmingLanguageRepository.deleteById(id);
		
	}
	
	@Override
	public void update(UpdateProgrammingLanguageRequests updateProgrammingLanguageRequests, int id) throws Exception{
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id);
		
		if(programmingLanguage.getLanguage().equalsIgnoreCase(updateProgrammingLanguageRequests.getLanguage())) {
			throw new Exception("this programming language is in list already.");
		}
		else {
			programmingLanguage.setLanguage(updateProgrammingLanguageRequests.getLanguage());
			this.programmingLanguageRepository.save(programmingLanguage);
		}
		
	}
	
	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<GetAllProgrammingLanguageResponse>();
		for(ProgrammingLanguage language : languages) {
			GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setLanguage(language.getLanguage());
			programmingLanguageResponses.add(responseItem);
			}
		return programmingLanguageResponses;
		}

	@Override
	public ProgrammingLanguage getById(int id) {
		return this.programmingLanguageRepository.findById(id);
	}

	@Override
	public ProgrammingLanguage getByResponseId(int id) {
		return this.programmingLanguageRepository.findById(id);
	}
	
	public boolean isLanguageExist(String programmingLanguage) throws Exception{
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		for(ProgrammingLanguage language : programmingLanguages) {
			if(language.getLanguage().equalsIgnoreCase(programmingLanguage)) {
				isExist = true;
			}
		}
		return isExist;
	}
}
