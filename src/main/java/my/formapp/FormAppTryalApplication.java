package my.formapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class FormAppTryalApplication {
	
	static <T1, T2> List<Pair<T1, T2>> zip(List<T1> c1, List<T2> c2) {
		int l = Math.min(c1.size(), c2.size());
		
		List<Pair<T1, T2>> dst = new ArrayList(); 
		for (int i = 0; i < l; ++i) {
			dst.add(new Pair<T1, T2>(c1.get(i), c2.get(i)));
		}
		
		return dst;
	}

	public static void main(String[] args) {
		String json = "{\"name\":{\"first\":\"joe\",\"last\":\"sixpack\"},\"gender\":\"male\",\"verified\":false,\"hoge\":[1,2,3]}";

		Pair<Integer, String> p = new Pair<Integer, String>(0, "s");
		
		List<String> hoge = Arrays.asList("a", "b", "c", "d", "e");
		
		List<Integer> huga = Arrays.asList(1,2,3,4,5);
		
		
		SpringApplication.run(FormAppTryalApplication.class, args);
	}
}
