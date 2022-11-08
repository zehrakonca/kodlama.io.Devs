package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.UnderLanguageService;
import kodlama.io.Devs.business.requests.languageRequests.UpdateProgrammingLanguageRequests;
import kodlama.io.Devs.business.requests.underLanguageRequests.CreateUnderLanguageRequest;
import kodlama.io.Devs.business.responses.underLanguageResponses.GetAllUnderLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.UnderLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.UnderLanguage;

@Service
public class UnderLanguageManager implements UnderLanguageService{
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private UnderLanguageRepository underLanguageRepository;
	
	boolean isExist = false;	
	
	@Autowired
	public UnderLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
			UnderLanguageRepository underLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.underLanguageRepository = underLanguageRepository;
	}

	@Override
	public void add(CreateUnderLanguageRequest createUnderLanguageRequest) throws Exception {
		
		UnderLanguage underLanguage = new UnderLanguage();
		underLanguage.setUnderLanguage(createUnderLanguageRequest.getUnderLanguage());
		if(underLanguage.getUnderLanguage()==null || createUnderLanguageRequest.getUnderLanguage().isEmpty()) {
			throw new Exception("this area cannot be blank");
		}
		else if(isUnderLanguageExist(underLanguage)) {
			throw new Exception("this programming language is in list already.");
		}
		else {
			ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createUnderLanguageRequest.getMainLanguageId());
			underLanguage.setProgramminglanguage(programmingLanguage);
			underLanguageRepository.save(underLanguage);
		}
	}
	
	@Override
	public void delete(int id) {
		this.underLanguageRepository.deleteById(id);
	}
	
	@Override
	public void update(UpdateProgrammingLanguageRequests updateProgrammingLanguageRequests, int id) throws Exception {
		UnderLanguage underLanguage = underLanguageRepository.findById(id);
		
		if(underLanguage.getUnderLanguage().equalsIgnoreCase(updateProgrammingLanguageRequests.getLanguage())) {
			throw new Exception("this technology is in list already");
		}
		else {
			underLanguage.setUnderLanguage(updateProgrammingLanguageRequests.getLanguage());
			this.underLanguageRepository.save(underLanguage);
		}
	}

	@Override
	public List<GetAllUnderLanguageResponse> getAll() {

		List<UnderLanguage> underLanguages = underLanguageRepository.findAll();
		List<GetAllUnderLanguageResponse> underLanguageResponses = new ArrayList<GetAllUnderLanguageResponse>();
		
		for(UnderLanguage underLanguage:underLanguages) {
			GetAllUnderLanguageResponse responseItem = new GetAllUnderLanguageResponse();
			responseItem.setId(underLanguage.getId());
			responseItem.setUnderLanguage(underLanguage.getUnderLanguage());
			responseItem.setMainLanguage(underLanguage.getProgramminglanguage().getLanguage());
			underLanguageResponses.add(responseItem);
		}
		return underLanguageResponses;
	}

	@Override
	public UnderLanguage getById(int id) {
		return this.underLanguageRepository.findById(id);
		
	}
	
	public boolean isUnderLanguageExist(UnderLanguage underLanguage) throws Exception{
        for(GetAllUnderLanguageResponse language : getAll()) {
            if(language.getUnderLanguage().equals(underLanguage.getUnderLanguage())) {
                isExist = true;
            }
        }
        return isExist;
    }
}