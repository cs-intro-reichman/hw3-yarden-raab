/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		//System.out.println(isAnagram("silent","listen"));  // true
		//System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		//System.out.println(isAnagram("Madam Curie","Radium came")); // true
		//System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		//System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
		s1 = s1.replaceAll(" ", "");
		String s2 = preProcess(str2);
		s2 = s2.replaceAll(" ", "");
		char c = 'a';
		String temp = "";
		for (int i=0; i<s1.length(); i++)
		{
			c=s1.charAt(i);
			if (s2.indexOf(c)==-1) {
				return false;
			}
			else {
				temp = Character.toString(c);
				s2 = s2.replaceFirst(temp, "");
			}
		}
		temp ="";
		if (!s2.equals(temp)) {
			return false;
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		char c ='a';
		String s = ""; 
		for (int i=0; i<str.length(); i++){
			c=str.charAt(i);
			if (((c>='a')&&(c<='z')) || (c==' ')) {
				s = s + c;
			}
			if ((c>='A')&&(c<='Z')) {
				s = s + Character.toLowerCase(c);
			}
		}
		return s;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int ran = (int) (Math.random() * str.length());
		char c = 'a';
		String empty = "";
		String temp = "";
		String newS = "";
		while (!str.equals(empty)) {
			ran = (int) (Math.random() * str.length());
			c = str.charAt(ran);
			temp = Character.toString(c);
			str = str.replaceFirst(temp, "");
			newS = newS + c;
		}
		return newS;
	}
}
