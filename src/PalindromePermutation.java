
public class PalindromePermutation 
{
	public static void main(String[] args)
	{
//		assert(false);
		// Does whitespace count? No.
		// Is it case sensitive? No.
		// ASCII v Unicode? ASCII is sufficient
		
		assert(PalindromePermutation("Tact Coa") == true);
		assert(PalindromePermutation("A man a car a maraca") == true);
		assert(PalindromePermutation("A Toyota's a Toyota") == true);
		assert(PalindromePermutation("A") == true);
		assert(PalindromePermutation("") == true);
		assert(PalindromePermutation("gaga") == true);
		assert(PalindromePermutation("Lady gaga") == false);
		assert(PalindromePermutation("my nana") == false);


		System.out.println("Done.");
	}
	
	/*
	 * OPTION 1: 
	 * Count the number of characters in the string
	 * Only 1 letter can occur an odd amount of times
	 * Separate counting and identifying odd count into separate functions
	 */
	public static boolean PalindromePermutation(String s)
	{
		s = s.toLowerCase();
		int[] numCharacters = new int[128]; // O(1) in space
		for(int i = 0; i < s.length(); ++i)
		{
			if((s.charAt(i) -'a' < 0) || (s.charAt(i) -'a' > 127))
				continue;
			
			int index = s.charAt(i) - 'a';
			numCharacters[index] += 1;
			
		}
		int oddCount = 0;
		for(int i = 0; i < numCharacters.length; ++i)
		{
			if(numCharacters[i] % 2 == 1)
				++oddCount;
		}
		
		if(oddCount > 1)
			return false;
		return true;
	}
}
