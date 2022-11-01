package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	
	void add(ProgrammingLanguage language);
	void update(ProgrammingLanguage language);
	void delete(int id);
	
	List<ProgrammingLanguage> getAll();
	
	ProgrammingLanguage getById(int id);
	ProgrammingLanguage getByLanguage(String language);

}
