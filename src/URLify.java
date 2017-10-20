
import java.util.Arrays;

public class URLify 
{
	public static void main(String[] args)
	{
//		assert(false);
		assert(URLify("Mr John Smith    ", 13).equals("Mr%20John%20Smith"));
		assert(URLify("Nandhini loves to code      ", 22).equals("Nandhini%20loves%20to%20code"));
		assert(URLify("a b c d      ", 7).equals("a%20b%20c%20d"));
		assert(URLify("Mr   ", 3).equals("Mr%20"));
		assert(URLify(" Smith  ", 6).equals("%20Smith"));
		assert(URLify("Nandhini Lakuduva  ", 17).equals("Nandhini%20Lakuduva"));
		assert(URLify("Nandhini  Lakuduva    ", 18).equals("Nandhini%20%20Lakuduva"));
		assert(URLify("   ", 1).equals("%20"));
		System.out.println("Done.");
	}
	
	/*
	 * Be careful. For char arrays, compare with '' NOT ""
	 * Be careful. Sufficient space != exact amount of space
	 * */
	public static String URLify(String s, int length)
	{
		char[] input = s.toCharArray();
		int spaces = 0;
		for(int i = length-1; i >= 0; --i)
		{
			if (input[i] == ' ')
				++spaces;
		}
		
		int letterOrSpacePtr = length-1; 
		int replacementPtr = (letterOrSpacePtr) + spaces*2;
		while(letterOrSpacePtr >= 0 && replacementPtr >= 0)
		{
			if(input[letterOrSpacePtr] != ' ')
			{
				input[replacementPtr] = input[letterOrSpacePtr];
				--replacementPtr;
				--letterOrSpacePtr;
			}
			else
			{
				input[replacementPtr] = '0';
				input[--replacementPtr] = '2';
				input[--replacementPtr] = '%';
				--replacementPtr;
				--letterOrSpacePtr;
			}
//			System.out.println(Arrays.toString(input) + " " + letterOrSpacePtr + " " + replacementPtr);
		}
		return new String(input);
	}
}
