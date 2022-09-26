package encodedecode;

import java.util.Base64;

public class Runner {
	
	public static void main(String[] args) {
		String encodedString=Base64.getEncoder().encodeToString("testingminibytes".getBytes());
		System.out.println(encodedString);
		
		String decodedString=new String(Base64.getDecoder().decode("dGVzdGluZ21pbmlieXRlcw==".getBytes()));
		System.out.println(decodedString);
	}

}
