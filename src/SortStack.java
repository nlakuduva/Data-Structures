import DataStructures.Stack;

public class SortStack 
{
	public static void main(String[] args)
	{
		Stack<Integer> st = new Stack<Integer>();
		st.push(1); st.push(2); st.push(3); st.push(4); st.push(5);
		sortStack(st);
		assert(st.toString().equals("Stack: 5 4 3 2 1 "));
		
		st.clear();
		st.push(1);
		sortStack(st);
		assert(st.toString().equals("Stack: 1 "));
		
		st.clear();
		st.push(5); st.push(2); st.push(1); st.push(4); st.push(3);
		sortStack(st);
		assert(st.toString().equals("Stack: 5 4 3 2 1 "));
		
		st.clear();
		st.push(5); st.push(4); st.push(3); st.push(2); st.push(1);
		sortStack(st);
		assert(st.toString().equals("Stack: 5 4 3 2 1 "));
		
		st.clear();
		st.push(7); st.push(4); st.push(100); st.push(2); st.push(0);
		sortStack(st);
		assert(st.toString().equals("Stack: 100 7 4 2 0 "));
		
		
		System.out.println("Done.");
	}

	public static void sortStack(Stack<Integer> st)
	{
		Stack<Integer> helperSt = new Stack<Integer>();
		int numSorted = 0;
//		while(numSorted <= st.getSize()/2)
		while(numSorted != st.getSize())
			numSorted = moveToHelper(st, helperSt, numSorted);
	}
	
	private static int moveToHelper(Stack<Integer> st, Stack<Integer> helperSt, int numSorted)
	{
		int max = -1;
		int valsVisited = st.getSize();
		while(!st.isEmpty() && valsVisited > numSorted)
		{
			int val = st.pop();
			if(val > max)
			{
				if(max > -1)
					helperSt.push(max);
				max = val;
			}
			else
				helperSt.push(val);
			
			--valsVisited;
		}
		st.push(max);
		
		moveBack(st, helperSt, numSorted);
		return ++numSorted;
	}
	
	private static void moveBack(Stack<Integer> st, Stack<Integer> helperSt, int numSorted)
	{
		while(!helperSt.isEmpty())
			st.push(helperSt.pop());
	}

}
