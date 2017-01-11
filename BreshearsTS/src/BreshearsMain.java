import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BreshearsMain {

	    public static void main(String[] args) {
	        //TODO: implement this 

	        //Freebie: this is one way to load the UTF8 formated character data.
	        BufferedReader indexReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));
	   ;
	    }
	    
	}


