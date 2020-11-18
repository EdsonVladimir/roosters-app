package util.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;


@Dependent
public class MathUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
    public double round(Double numero, Integer digits) {
     	Double result = 0.0;
     	if(numero != null){
     		int cifras = (int) Math.pow(10, digits);
            result = Math.rint(numero * cifras) / cifras;
     	}
         return result;
     }
    

    public double nextTop(double numero) {
        int out = 0;
        int cociente;
        int index = 0;
        for (int i = 1; numero != 0; i++) {
            cociente = (int) (numero / 10);
            numero = cociente;
            index = i;
        }
        out = (int) Math.pow(10, index);
        return out;
    }

    public int nextTopScale(double numero) {
        int out = 0;
        double roundIndex = Math.ceil(numero / 100);
        out = (int) (roundIndex * 100);
        return out;
    }

    public List<Integer> generateNumericList(int from, int to) {
        List<Integer> lista = new ArrayList<Integer>();
        for (int x = from; x <= to; x++) {
            lista.add(x);
        }
        return lista;
    }
    
    public Double percentage(Double total, Double score){
    	Double result;
    	if (total == 0.0) {
    		result = 0.0;
		}
    	else {
    		result = ((score / total) * 100);
		}
    	return result;
    }
    
    public Integer chunks(Integer itemsize, Integer block){
    	Integer chunks = 0;
    	if(itemsize == 0){
    		chunks = 0;
    	}
    	else {
    		if(itemsize <= block){
    			chunks = 1;
    		}
    		else{
    			chunks = (int) Math.ceil(itemsize/block);
    		}
    	}
    	return chunks;    	
    }

   
	

}
