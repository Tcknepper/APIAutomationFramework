package utility;

public class Authenticate {

	//bearer token never changes so it is final
	public final static String bearer_token = "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";
	
	public static String getBearerToken() {
		return bearer_token;
	}
}
