package my.formapp;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestPassController {

	@GetMapping(path="/rest", produces = MediaType.APPLICATION_JSON_VALUE)
	public String rest() {
		String url = "http://api.aoikujira.com/kawase/get.php?code=USD&format=json";
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, String.class);
	}

}
