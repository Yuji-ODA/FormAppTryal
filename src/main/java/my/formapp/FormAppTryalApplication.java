package my.formapp;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class FormAppTryalApplication {

	public static void main(String[] args) {
		String json = "{\"name\":{\"first\":\"joe\",\"last\":\"sixpack\"},\"gender\":\"male\",\"verified\":false,\"hoge\":[1,2,3]}";
//		System.out.println(json);
		//LinkedHashMapを使うと順序が保持される

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		Map result = null;
		try {
			result = mapper.readValue(json, LinkedHashMap.class);
			System.out.println(mapper.writeValueAsString(result));	
		} catch (Exception ex) {
			
		}

//		System.out.println(result.toString());
		for (Object key : result.keySet()) {
			System.out.println(key);
			Object value = result.get(key);
			System.out.println(value.getClass());
			if (value instanceof LinkedHashMap) {
				LinkedHashMap map = (LinkedHashMap)value;
				for (Object mapkey : map.keySet()) {
					System.out.println("  " + mapkey.getClass());
					System.out.println("  " + mapkey);
					System.out.println("  " + map.get(mapkey).getClass());
					System.out.println("  " + map.get(mapkey));
				}
			}
		}
		
		JsonNode root = null;
		try {
			root = new ObjectMapper().readTree(json);
			
		} catch (Exception ex) {
			
		}
		
		JsonNode hoge = root.get("hoge");
		
		System.out.println(root);
		
		SpringApplication.run(FormAppTryalApplication.class, args);
	}
}
