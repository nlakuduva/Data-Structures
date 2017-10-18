
public class PermutationCheck 
{
	/*
	 * ASK: 
	 * ASCII vs. Unicode
	 * Case sensitive?
	 * One word vs. multiple words? White space?
	 * 
	 * */
	
	/* OPTION 1:
	 * check if same length --> if not return false
	 * create two hashmaps -> Space: O(n)
	 * populate them O(2n) --> O(n) 
	 * iterate through one hash map looking for the other letter and check the count
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * */
	
	/*
	 * OPTION 2
	 * Sort both Strings --> O(nlogn)
	 * check if they are both equal --> O(n)
	 * Time complexity: O(nlogn)
	 * Space complexity: O(1)
	 */
	
	/*
	 * OPTION 3
	 * create 2 char_set array
	 * populate them by index O(n)
	 * run through and check if every index is same
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	
	/*
	 * OPTION 4
	 * create 1 char_set array
	 * populate them by index O(n)
	 * run through and decrement index and make sure nothing is less than zero
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
}
