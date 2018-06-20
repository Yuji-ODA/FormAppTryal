package my.formapp;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="donata_data")
public class DonataDataController {

	@GetMapping(path = "data_names")
	public String dataNames() {
		return "data names";
	}

	@GetMapping(path = "data_info/{data_name}")
	public String dataInfo(@PathVariable String data_name, Model model) {
		return data_name;
	}
	
}


