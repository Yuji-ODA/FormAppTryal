package my.formapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="hoge")
public class HogeController {

	@GetMapping(path="")
	public String Hoge(Model model) {
		RowClass hoge = new RowClass("aaaaa");
		hoge.addCell("1");
		hoge.addCell("2");
		hoge.addCell("3");
		hoge.addCell("4");
		hoge.addCell("5");
		
		RowClass huga = new RowClass("bbbbb");
		huga.addCell("a");
		huga.addCell("b", 2);
		huga.addCell("c");
		huga.addCell("d");
		
		model.addAttribute("rows", new RowClass[] {hoge, huga});
		
		return "hoge";
	}
	
	public static class RowClass {

		private String id;
		private List<CellClass> cells;

		class CellClass {
			private String value;
			private int span;
			
			CellClass(String value) {
				this(value, 1);
			}
			
			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public int getSpan() {
				return span;
			}

			public void setSpan(int span) {
				this.span = span;
			}

			CellClass(String value, int span) {
				this.value = value;
				this.span = span;
			}
		}
		
		public void addCell(String value) {
			cells.add(new CellClass(value, 1));
		}
		
		public void addCell(String value, int span) {
			cells.add(new CellClass(value, span));
		}
		
		public RowClass(String id) {
			this.id = id;
			this.cells = new ArrayList<CellClass>();
		}

		public String getId() {
			return id;
		}

//		public void setId(String id) {
//			this.id = id;
//		}

		public List<CellClass> getCells() {
			return cells;
		}

//		public void setValues(List<CellClass> cells) {
//			this.cells = cells;
//		}
		
		
	}
	
}
