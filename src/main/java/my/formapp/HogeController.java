package my.formapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="hoge")
public class HogeController {

	@GetMapping(path="")
	public String Hoge(Model model) {
		
		HogeClass[] hogees = new HogeClass[] {
				new HogeClass("aaaaa", new String[] {"1", "2", "3", "4", "5"}),
				new HogeClass("bbbbb", new String[] {"a", "b", "c", "d", "f"})
			};
		
		model.addAttribute("hogees", hogees);
		
		return "hoge";
	}
	
	public static class HogeClass {

		private String id;
		private String values[];
		
		public HogeClass(String id, String[] values) {
			this.id = id;
			this.values = values;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String[] getValues() {
			return values;
		}

		public void setValues(String[] values) {
			this.values = values;
		}
		
	}
	
}
