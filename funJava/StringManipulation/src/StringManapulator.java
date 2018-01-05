
public class StringManapulator {
	public String trimAndConcat(String word1, String word2) {
		String w1 = word1.trim();
		String w2 = word2.trim();
		String result = w1 + w2;
		return result;
		
	}
	public Integer getIndexOrNull(String word, char letter) {
		String str = "" + letter;
		int value = word.indexOf(str);
		if (value < 0) {
			return null;
		}else {
			return value;
		}
	
	}
	public Integer getIndexOrNull(String word1, String word2) {
		int value = word1.indexOf(word2);
		if (value < 0) {
			return null;
		}else {
			return value;
		}
	}
	public String concatSubstring(String str1, int num1, int num2, String str2) {
		String newWord = str1.substring(num1, num2);
		String newResult = newWord + str2;
		
		return newResult;
		
	}
	
}
	
	

