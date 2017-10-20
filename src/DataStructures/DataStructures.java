package DataStructures;

import java.util.List;
import java.util.ArrayList;

public class DataStructures
{
	public static void main (String[] args)
	{
		testStack();
		testLinkedList();
		testQueue();
		testArrayList();
		 testSet();
		
		testBST();
		testHeap();
		//map, hash table, PQ, graph

	}
	public static void testStack()
	{
		
		Stack<String> mystack = new Stack<String>();
		System.out.println(mystack);
		mystack.push("jello"); //push when empty
		System.out.println("Is stack empty? " + mystack.isEmpty());
		System.out.println(mystack.peek()); //peek with one object
		System.out.println(mystack);
		mystack.push("baboo is the best"); //push when not empty
		System.out.println(mystack); 
		System.out.println(mystack.peek()); //peek with two objects
		mystack.pop(); //pop when more than 1 object
		System.out.println(mystack);
		mystack.pop(); //pop when 1 object
		System.out.println(mystack);
		System.out.println(mystack.peek()); //peek when no object
		mystack.pop(); //pop when no object
		System.out.println("Is stack empty? " + mystack.isEmpty());
	}
	
	public static void testLinkedList()
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		System.out.println(ll);
		ll.add(10, 9); //adding at a index
		System.out.println(ll);
		ll.remove();
		System.out.println(ll + "size:" + ll.getSize());
		ll.remove(2); //removing from an index
		System.out.println(ll);
		ll.removeHead();
		System.out.println(ll);
		ll.remove(8);
		System.out.println(ll);
		ll.add(2, 90);
		System.out.println(ll);
		ll.addHead(783839);
		System.out.println(ll);
		System.out.println(ll.isEmpty());
		System.out.println(ll.get(5)); //get at oob index
		System.out.println(ll.get(2));
		ll.set(2, 4432432);
		System.out.println(ll);
		System.out.println(ll.contains(9));
		System.out.println(ll.contains(4));
		ll.remove();
		ll.remove();
		ll.remove(); //removing when multiple objs
		ll.remove(); //removing when only 1 obj
		System.out.println(ll);
		ll.remove(); //removing when theres nothing

	}
	
	public static void testQueue()
	{
		Queue<String> myqueue = new Queue<String>();
		System.out.println(myqueue);
		myqueue.push("jello"); //push when empty
		System.out.println("Is queue empty? " + myqueue.isEmpty());
		System.out.println(myqueue.peek()); //peek with one object
		System.out.println(myqueue);
		myqueue.push("baboo is the best"); //push when not empty
		System.out.println(myqueue); 
		System.out.println(myqueue.peek()); //peek with two objects
		myqueue.pop(); //pop when more than 1 object
		System.out.println(myqueue);
		myqueue.pop(); //pop when 1 object
		System.out.println(myqueue);
		System.out.println(myqueue.peek()); //peek when no object
		myqueue.pop(); //pop when no object
		System.out.println("Is queue empty? " + myqueue.isEmpty());
	}
	
	public static void testArrayList()
	{
		ArrayList<Integer> theirs = new ArrayList<Integer>();
		MyArrayList<Integer> mine = new MyArrayList<Integer>();
		System.out.println(theirs +"\t" + mine);
		theirs.add(5); //adds when empty
		mine.add(5);
		theirs.add(6); //adds when filled
		mine.add(6);
		theirs.add(10);
		mine.add(10);
		theirs.add(11);
		mine.add(11);
		System.out.println(theirs +"\t" + mine);
		theirs.add(3, 12); //adds at index
		mine.add(3, 12);
		System.out.println(theirs +"\t" + mine);
		theirs.remove(2); //removes at index
		mine.remove(2);
		System.out.println(theirs +"\t" + mine);
		for(int i = 0; i < 10; i++) //tests array growth
		{
			int n = (int) (Math.random() * 10) + 1;
			theirs.add(n);
			mine.add(n);
		}
		System.out.println(theirs +"\t" + mine);
		theirs.add(theirs.size(), 5); //adds at end
		mine.add(mine.size(), 5);
		System.out.println(theirs +"\t" + mine);
		theirs.clear(); //clears
		mine.clear();
		System.out.println(theirs +"\t" + mine);
		theirs.add(1);
		mine.add(1);
		theirs.add(2);
		mine.add(2);
		theirs.add(3);
		mine.add(3);
		theirs.add(4);
		mine.add(4);
		theirs.add(5);
		mine.add(5);
		theirs.add(6);
		mine.add(6);
		System.out.println(theirs +"\t" + mine);
		theirs.remove(new Integer(3)); //remove by object
		mine.remove(new Integer(3));
		System.out.println(theirs +"\t" + mine);
		System.out.println(theirs.get(3) +"\t" + mine.get(3)); //get
		System.out.println(theirs.contains(2) +"\t" + mine.contains(2)); //contains
		theirs.set(2, 8); //sets at index
		mine.set(2,8);
		System.out.println(theirs +"\t" + mine);
		System.out.println(theirs.size() +"\t" + mine.size());
	}
	
	public static void testSet()
	{
		Set<Integer> myset = new Set<Integer>();
		System.out.println(myset.add(8));
		myset.add(7);
		myset.add(0);
		System.out.println(myset.add(8));
		
		Set<String> myset2 = new Set<String>();
		System.out.println(myset2.add("hello"));
		myset.add("boy");
		myset.add("bye");
		System.out.println(myset.add("" + "hello"));
	}

	public static void testBST()
	{
		TreeNode<Integer> node = new TreeNode<Integer>(2);
		Tree<Integer> tree = new Tree<Integer>(node);
//		tree.insert(5);
//		tree.insert(1);
//		tree.insert(8);
//		tree.insert(4);
//		tree.insert(2);
//		tree.insert(0);
//		tree.insert(6);
//		tree.insert(10);
//		tree.insert(3);
//		tree.insert(-1);
//		tree.insert(-5);
//		//tree.inorder(tree);
//		tree.remove(6);
		tree.printOut();
		//System.out.println(tree.search(2).getValue());
		
	}
	
	public static void testHeap()
	{
		TreeNode<Integer> node = new TreeNode<Integer>(2);
		Heap<Integer> tree = new Heap<Integer>(node);
		tree.insert(5);
		tree.insert(1);
		tree.insert(8);
		tree.insert(4);
		tree.insert(2);
		tree.insert(0);
		tree.insert(6);
		tree.insert(10);
		tree.insert(3);
		tree.insert(-1);
		tree.insert(-5);
		//tree.inorder(tree);
		tree.printOut();
		//System.out.println(tree.search(2).getValue());
		
	}
}