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
		if(st.getSize() <= 1)
			return;
		
		Stack<Integer> helperSt = new Stack<Integer>();
		int numSorted = 0;
		while(numSorted <= st.getSize()/2)
		{
			moveToHelper(st, helperSt, numSorted);
			moveToSt(helperSt, st, numSorted);
			++numSorted;
		}
		moveBack(st, helperSt, numSorted);
			

	}
	
	private static void moveToHelper(Stack<Integer> st, Stack<Integer> helperSt, int numSorted)
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
	}
	
	private static void moveToSt(Stack<Integer> st, Stack<Integer> helperSt, int numSorted)
	{
		int min = Integer.MAX_VALUE;
		int valsVisited = st.getSize();
		while(!st.isEmpty() && valsVisited > numSorted)
		{
			int val = st.pop();
			if(val < min)
			{
				if(min < Integer.MAX_VALUE)
					helperSt.push(min);
				min = val;
			}
			else
				helperSt.push(val);
			
			--valsVisited;
		}
		st.push(min);
	}
	
	private static void moveBack(Stack<Integer> st, Stack<Integer> helperSt, int numSorted)
	{
		while(!helperSt.isEmpty())
			st.push(helperSt.pop());
	}
	
	

}
