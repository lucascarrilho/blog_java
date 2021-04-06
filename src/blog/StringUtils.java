package blog;

public class StringUtils {
	
	public static boolean empty(String str) {
		if(str.equals("")) {
			return true;
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ' && str.charAt(i) != '\t') {
				return false;
			}
		}
		
		return true;
	}

}
