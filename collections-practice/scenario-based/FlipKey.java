import java.util.Scanner;

public class FlipKey {
	public static void main(String args[]) {
		
		//Create Scanner Object
		Scanner sc = new Scanner(System.in);
		
		String  str = sc.next();
		System.out.println(cleanAndInvert(str));
	}
	
	public static String cleanAndInvert(String str) {
		
		String regex = "^[A-Za-z]+$";
		
		if(!str.matches(regex) || str.length()<6) {
			return "";
		}
		
		StringBuilder result= new StringBuilder();
		str = str.toLowerCase();
		
		for(int i=0;i<str.length();i++) {
			int ch = (int)str.charAt(i);
			
			if(!(ch%2==0)) {
				result.append(str.charAt(i));
			}
		}
		
		result.reverse();
		
		for (int i = 0; i < result.length(); i++) {
	            if (i % 2 == 0) { // even index
	                result.setCharAt(i, Character.toUpperCase(result.charAt(i)));
	            }
	        }
		return result.toString();
	}
}