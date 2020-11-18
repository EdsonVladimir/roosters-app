package util.common;

import java.io.StringReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;


public class JwtUtil {
	

	public static String createJwt(String privateKey64, String username, List<String> groups, Map<String, String> claims){
		String result = null;
		try {
			JsonObjectBuilder headerBuilder = Json.createObjectBuilder();
			headerBuilder.add("alg", "RS256");
			headerBuilder.add("typ", "JWT");
			JsonObject headerJson = headerBuilder.build();
			String headerEnc = Base64Util.encode(headerJson.toString());
			
			JsonObjectBuilder claimsBuilder = Json.createObjectBuilder();
			claimsBuilder.add("exp", (System.currentTimeMillis() / 1000) + 864000);	//5 days
			claimsBuilder.add("iat", (System.currentTimeMillis() / 1000));
			claimsBuilder.add("aud", "asterisk360");
			claimsBuilder.add("jti", Long.toHexString(System.nanoTime()));
			claimsBuilder.add("sub", username);
			claimsBuilder.add("upn", username);
			claimsBuilder.add("iss", "asterisk360");
			
			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
			if (groups != null) {
				for (String group : groups) {
					arrayBuilder.add(group);
				}
			}
			JsonArray roles = arrayBuilder.build();
			claimsBuilder.add("groups", roles);
			
			
			//*360
			if (claims != null) {
				if (!claims.isEmpty()) {
					claims.entrySet().stream().forEach(e -> claimsBuilder.add(e.getKey(), e.getValue()));	
				}	
			}
			
			JsonObject claimsJson = claimsBuilder.build();
			String claimsEnc = Base64Util.encode(claimsJson.toString());
		    
		    String headerClaimsEnc = headerEnc + "." + claimsEnc;
			
					
			byte[] decodedKey64 = Base64Util.decode(privateKey64);
			PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decodedKey64));
			
			// Sign the JWT
			Signature sig = Signature.getInstance("SHA256withRSA");
			sig.initSign(privateKey);
			sig.update(headerClaimsEnc.getBytes());
			String sigEnc = Base64Util.encode(sig.sign());
			result = headerClaimsEnc + "." + sigEnc;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return result;		
	}
	
	
	public static String getClaim(String jwt, String claim) {
		String result = null;
		try {
			StringTokenizer st = new StringTokenizer(jwt.substring(7), ".");
			st.nextToken();			
			String json = new String(Base64Util.decode(st.nextToken()));
			JsonReader jsonReader = Json.createReader(new StringReader(json));
		    JsonObject reply = jsonReader.readObject();
		    result = reply.getString(claim);			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	


}