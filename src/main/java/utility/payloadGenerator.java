package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadGenerator {

	//method used to generate a payload using a json file
	public static String generateStringPayload(String fileName) throws IOException {
		//creating the file path dynamically based on passed file name
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\"+fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
}
