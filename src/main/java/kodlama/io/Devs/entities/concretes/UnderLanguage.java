package kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="under_Languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UnderLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="underLanguage_id")
	private int id;
	
	@Column(name="under_language")
	private String underLanguage;
	
	@ManyToOne
	@JoinColumn(name="language_id")
	public ProgrammingLanguage programminglanguage;
}
