package my.formapp.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import my.formapp.FileRequired;

@Data
public class UserForm {
	
	@Min(1)
	private int id;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Size(min=4, max=35)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@FileRequired
    private MultipartFile multipartFile;

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}

