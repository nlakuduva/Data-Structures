public class OneAway 
{
	public static void main (String[] args)
	{
		// Does whitespace count? No.
		// Is it case sensitive? No.
		// ASCII v Unicode? Alphabet letters is sufficient
		
//		 assert(false);
		assert(checkIfOneAway("pale", "pale") == true);
		assert(checkIfOneAway("pale", "ple") == true);
		assert(checkIfOneAway("pales", "pale") == true);
		assert(checkIfOneAway("pale", "bale") == true);
		assert(checkIfOneAway("pale", "bake") == false);
		assert(checkIfOneAway("a", "b") == true);
		assert(checkIfOneAway("abcd", "bcd") == true);
		assert(checkIfOneAway("abcd", "cd") == false);
		assert(checkIfOneAway("abcd", "abc") == true);
		assert(checkIfOneAway("abcd", "ab") == false);
		assert(checkIfOneAway("bcde", "abcde") == true);
		assert(checkIfOneAway("bcde", "zabcde") == false);
		assert(checkIfOneAway("abcd", "abcde") == true);
		assert(checkIfOneAway("abcd", "abcdef") == false);
		assert(checkIfOneAway("abcd", "zbcd") == true);
		assert(checkIfOneAway("abcd", "zycd") == false);
		assert(checkIfOneAway("nandhini", "mandhini") == true);
		assert(checkIfOneAway("nandhini", "mamdhimi") == false);
		System.out.println("Done.");
	}

	/*
	 * Check the lengths of the two strings:
	 * 	if equal --> check for exactly one subs
	 *  if diff = s2 length - s1 length = 1  --> check for one addition
	 *  if diff = -1 --> check for one deletion
	 *  if diff > 1 or diff < -1 --> return false
	 *  
	 * */
	private static boolean checkIfOneAway(String original, String edited) {
		int diff = edited.length() - original.length();
		if(diff == 0 || diff == 1)
			return checkForSingleMutation(original, edited);
		else if (diff == -1)
			return checkForSingleMutation(edited, original);
		else
			return false;
	}

	private static boolean checkForSingleMutation(String original, String edited) 
	{
		boolean sameLength = (edited.length() - original.length() == 0);
		boolean edit = false;
		int originalIdx = 0;
		for(int editedIdx = 0; editedIdx < edited.length(); ++editedIdx)
		{
			if (originalIdx >= original.length())
				break;
			
			if(original.charAt(originalIdx) != edited.charAt(editedIdx))
			{
				if(edit == true)
					return false;
				else
					edit = true;
				
				if(sameLength)
					++originalIdx;
			}
			else
				++originalIdx;
		}
		return true;
	}

//	private static boolean checkForSingleSubstitute(String original, String edited) 
//	{
//		boolean edit = false;
//		for(int i = 0; i < original.length(); ++i)
//		{
//			if(original.charAt(i) != edited.charAt(i))
//			{
//				if(edit == true)
//					return false;
//				else
//					edit = true;
//			}
//		}
//		return true;
//	}


}
