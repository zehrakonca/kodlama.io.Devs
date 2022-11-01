package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.dataAccess.concretes.InMemoryProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private List<ProgrammingLanguage> programmingLanguage;
	private InMemoryProgrammingLanguage inMemoryRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
			List<ProgrammingLanguage> programmingLanguage, InMemoryProgrammingLanguage inMemoryRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.programmingLanguage = programmingLanguage;
		this.inMemoryRepository = inMemoryRepository;
	}

	@Override
	public void add(ProgrammingLanguage language) {
		for(ProgrammingLanguage languages: inMemoryRepository.programmingLanguages) {
			if (languages.getLanguage().equals(language.getLanguage()) && languages.getLanguage().isEmpty()) {
				System.out.println("the value cannot be repeated or be blank.");
			}
			else {
				programmingLanguageRepository.add(language);
			}
		}
		
	}

	@Override
	public void update(ProgrammingLanguage language) {
		programmingLanguageRepository.update(language);
		
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

	@Override
	public ProgrammingLanguage getByLanguage(String language) {
		return programmingLanguageRepository.getByLanguage(language);
	}
	
}
