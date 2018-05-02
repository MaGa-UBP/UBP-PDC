package ar.edu.ubp.das.util;

public class MyStringFunctions {

    public static String lower(String param) {
        return param.toLowerCase();
    }

    public static String upper(String param) {
        return param.toUpperCase();
    }
	
    public static String wordcap(String param) {
    	StringBuilder string = new StringBuilder(param.length());
    	String[]      words  = param.split("\\s");
    	
    	for(int i = 0, len = words.length; i < len; i++) {
    	  string.append(Character.toUpperCase(words[i].charAt(0)))
    	        .append(words[i].substring(1).toLowerCase())
    	        .append(" ");
    	}    
    	string.trimToSize();
    	return string.toString();
    }
        
    public static int charToAscii(char character){
        return (int)character;
    }    
    
    public static char asciiToChar(int ascii){
        return (char)ascii;		
    }    

}
