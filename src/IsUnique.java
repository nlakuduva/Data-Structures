
import java.util.Arrays;

public class IsUnique 
{
	public static void main(String[] args)
	{
		
		/*
		 * int val= str.charAt(i) - 'a';
		 * Consider bit vector approach next time
		 * */
		System.out.println(isUnique("uncopyrightable"));
	}
	
	public static boolean isUnique(String s)
	{
		char[] letters = s.toCharArray();
		Arrays.sort(letters);
		
		int i = 0;
		while((i < letters.length-1))
		{
			if (letters[i] == letters[i+1])
				return false;
			++i;
		}
		return true;
	}
}
