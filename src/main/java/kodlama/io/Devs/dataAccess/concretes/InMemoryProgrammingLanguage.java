package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguage implements ProgrammingLanguageRepository {

	public List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgrammingLanguage() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "JAVA"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Ruby"));
		programmingLanguages.add(new ProgrammingLanguage(3, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(4, "Pyhthon"));
		programmingLanguages.add(new ProgrammingLanguage(5, "Matlab"));
		programmingLanguages.add(new ProgrammingLanguage(6, "C"));
		programmingLanguages.add(new ProgrammingLanguage(7, "C++"));
		programmingLanguages.add(new ProgrammingLanguage(8, "PHP"));
		programmingLanguages.add(new ProgrammingLanguage(9, "GO"));
		programmingLanguages.add(new ProgrammingLanguage(10, "Kotlin"));
		
	}

	@Override
	public void add(ProgrammingLanguage language) {
		programmingLanguages.add(language);
		
	}

	@Override
	public void update(ProgrammingLanguage language) {
		for(ProgrammingLanguage language1: programmingLanguages) {
			if(language1.getId()==language1.getId()) {
				language1.setLanguage(language1.getLanguage());
			}
		}
		
	}

	@Override
	public void delete(int id) {
		programmingLanguages.remove(id);
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage language: programmingLanguages) {
			if(language.getId()==id) {
				return language;
			}
		}
		return null;
	}

	@Override
	public ProgrammingLanguage getByLanguage(String language) {
		for(ProgrammingLanguage language1:programmingLanguages) {
			if(language1.getLanguage()==language) {
				return language1;
			}
		}
		return null;
	}
	
}
