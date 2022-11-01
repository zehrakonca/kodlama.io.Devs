package kodlama.io.Devs.entities.concretes;

public class ProgrammingLanguage {
	private int id;
	private String language;
	
	public ProgrammingLanguage() {
		super();
	}

	public ProgrammingLanguage(int id, String language) {
		super();
		this.id = id;
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
