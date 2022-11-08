package kodlama.io.Devs.business.requests.underLanguageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUnderLanguageRequest {
	
	private int mainLanguageId;
	private String underLanguage;
	
}
