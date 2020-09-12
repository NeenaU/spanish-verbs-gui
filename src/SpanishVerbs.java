/**
 * Contains code for conjugating a verb for a chosen tense based on user input
 * Also contains code to validate a verb and tense entered by the user
 * 
 * @author Neena Ugail
 * @version 2.0
 *
 */
public class SpanishVerbs {	
	
	/*Conjugations*/
	static String yo;
	static String tu;
	static String you;
	static String nosotros;
	static String vosotros;
	static String youAll;
	
	/*2D array with verb endings*/
	static String[][] endings = {{"o","as","a","amos","\u00E1is","an"}, {"o","es","e","emos","\u00E9is","en"}, {"o","es","e","imos","\u00EDs","en"}, 
			{"\u00E9","aste","\u00F3","amos","asteis","aron"}, {"\u00ED","iste","i\u00F3","imos","isteis","ieron"}, {"aba","abas","aba","\u00E1bamos","abais","aban"},
			{"\u00EDa","\u00EDas","\u00EDa","\u00EDamos","\u00EDais","\u00EDan"}, {"ar\u00EDa","ar\u00EDas","ar\u00EDa","ar\u00EDamos","ar\u00EDais","ar\u00EDan"},
			{"er\u00EDa","er\u00EDas","er\u00EDa","er\u00EDamos","er\u00EDais","er\u00EDan"}, {"ir\u00EDa","ir\u00EDas","ir\u00EDa","ir\u00EDamos","ir\u00EDais","ir\u00EDan"},
			{"ar\u00E9","ar\u00E1s","ar\u00E1","aremos","aru\0233is","ar\u00E1n"}, {"er\u00E9","er\u00E1s","er\u00E1","eremos","er\u00E9is","er\u00E1n"},
			{"ir\u00E9","ir\u00E1s","ir\u00E1","iremos","ir\u00E9is","ir\u00E1n"}};
	
	/**
	 * Constructor used to set field values
	 */
	public SpanishVerbs() {
	}
	
	/**
	 * Validating the verb by checking if it has a valid ending
	 * @param s: The string to be validated
	 * @return Whether the verb is valid
	 */
	public static boolean validateVerb(String s) {
		
		s = s.toLowerCase();
		
		if (s.length() > 2) { 
			String lastTwoLetters = s.substring(s.length()-2);
			
			switch(lastTwoLetters) { //If verbs end in ar, er or ir they are valid
				case "ar": 
					return true;
				case "er": 
					return true;
				case "ir": 
					return true;
				default:
					return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * Validating the tense by checking if the user has entered a valid number
	 * @param s: The number to be validated
	 * @return: Whether the tense is valid
	 */
	public static Boolean validateTense(String s) {
		try {
			int tense = Integer.parseInt(s);
			
			if (tense > 5 || tense < 1) { //Numbers between 1 and 5 are valid
				return false;
			}				
		}
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Selecting the correct endings from the endings array to conjugate the verb
	 * @param verb: The verb to be conjugated
	 * @param t: The user's chosen tense
	 * @return: The endings needed to conjugate the verb
	 */
	public static String[] conjugate(String verb, String t) {
		
		//Position in the endings array to find the correct endings
		int index = 0;
		//Whether the verb ends in ar, er or ir
		int verbEnding = 0;
		
		int tense = Integer.parseInt(t);
		
		String lastTwoLetters = verb.substring(verb.length()-2);
		
		switch(lastTwoLetters) {
			case "ar": 
				verbEnding = 1;
			case "er": 
				verbEnding = 2;
			case "ir": 
				verbEnding = 3;
		}
		
		switch(tense) { //Select correct array of endings from 2D array
			case 1:
				if (verbEnding == 1) {
					index = 0;
				}
				else if (verbEnding == 2) {
					index = 1;
				}
				else if (verbEnding == 3){
					index = 2;
				}
				break;
			case 2: 
				if (verbEnding == 1) {
					index = 3;
				}
				else if (verbEnding == 2 || verbEnding == 3) {
					index = 4;
				}
				break;
			case 3:
				if (verbEnding == 1) {
					index = 5;
				}
				else if (verbEnding == 2 || verbEnding == 3) {
					index = 6;
				}
				break;
			case 4:
				if (verbEnding == 1) {
					index = 7;
				}
				else if (verbEnding == 2) {
					index = 8;
				}
				else if (verbEnding == 3){
					index = 9;
				}
				break;
			case 5:
				if (verbEnding == 1) {
					index = 10;
				}
				else if (verbEnding == 2) {
					index = 11;
				}
				else if (verbEnding == 3){
					index = 12;
				}
				break;
		}
		
		String[] conjugations = new String[6];
		
		conjugations[0] = endings[index][0];
		conjugations[1] = endings[index][1];
		conjugations[2] = endings[index][2];
		conjugations[3] = endings[index][3];
		conjugations[4] = endings[index][4];
		conjugations[5] = endings[index][5];
		
		return(conjugations);
		
	}
}
