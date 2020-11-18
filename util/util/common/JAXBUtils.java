package util.common;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class JAXBUtils {
	
	public static String Object2XmlString(Object object) {
		
		try{
			StringWriter writer = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//jaxbMarshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			jaxbMarshaller.marshal(object, writer);
			return writer.toString();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object XmlString2Object(String xmlString,Object object) {
		try{
			StringReader reader = new StringReader(xmlString);
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return jaxbUnmarshaller.unmarshal(reader);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


}
