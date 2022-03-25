package utility;

public class createURL {

	//API URI never changes so it is final
	public final static String baseURI = "https://api.github.com";
	
	public static String getBaseURI() {
		return baseURI;
	}
	
	public static String getBaseURI(String resourcePath) {
		//generates a base URI if you pass a string parameter to the method
		return baseURI+resourcePath;
	}
}
