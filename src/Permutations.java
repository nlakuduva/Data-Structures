
import java.util.ArrayList;
import java.util.List;

public class Permutations 
{
	public static void main(String[] args)
	{
		for(String s : permutations("abcd", 4))
			System.out.println(s);
	}
	
	private static List<String> permutations(String s, int len)
	{
		if(s.length() == 1)
		{
			List<String> out = new ArrayList<String>();
			out.add(s);
			return out;
		}
		
		List<String> prev = permutations(s.substring(0, s.length()-1), len);
		List<String> out = new ArrayList<String>();
		for (String p : prev)
		{
			char letter = s.charAt(s.length()-1);
			for (int i = 0; i <= p.length(); i++)
			{
				out.add(p.substring(0, i) + letter + p.substring(i));
			}
		}
		return out;

		
		
	}

}
