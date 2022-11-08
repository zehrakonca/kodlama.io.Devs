package kodlama.io.Devs.business.responses.underLanguageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUnderLanguageResponse {
	private int id;
	private String underLanguage;
	private String mainLanguage;
}
