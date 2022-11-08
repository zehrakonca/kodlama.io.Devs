package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.UnderLanguage;

public interface UnderLanguageRepository extends JpaRepository<UnderLanguage, Integer>{
	UnderLanguage findById(int id);
}
