package Exercises;

public class URLify 
{
	public static void main(String[] args)
	{
//		assert(false);
		assert(URLify("Mr John Smith    ", 13).equals("Mr%20John%20Smith"));
		assert(URLify("Nandhini loves to code      ", 22).equals("Nandhini&20love%20to&20code%20"));
		assert(URLify("a b c d      ", 7).equals("a%20b%20c%20d"));
		assert(URLify("Mr   ", 2).equals("Mr%20"));
		assert(URLify(" Smith  ", 6).equals("%20Smith"));
		assert(URLify("Nandhini Lakuduva  ", 17).equals("Nandhini%20Lakuduva"));
		assert(URLify("Nandhini  Lakuduva    ", 18).equals("Nandhini%20%20Lakuduva"));
		assert(URLify("   ", 1).equals("%20"));
	}
	
	/*
	 * 
	 * */
	public static String URLify(String s, int length)
	{
		
		return "";
	}
}
