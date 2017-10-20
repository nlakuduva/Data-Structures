import DataStructures.Node;

public class Partition 
{
	public static void main (String[] args)
	{
//		assert(false);
		int[] nums = {3,5,8,5,10,2,1};
		Node<Integer> head = new Node<Integer>();
		Node<Integer> node = head;
		for(int i = 0; i < nums.length; ++i)
		{
			int n = nums[i];
			node.setVal(n);
			Node<Integer> next = new Node<Integer>();
			node.setNext(next);
			node = next;
		}
//		node.setVal(nums[nums.length-1]);
		
		node = head;
		while(node != null)
		{
//			System.out.println(node);
			node = node.getNext();
		}
		
		partition(head, 5);
		node = head;
		while(node != null)
		{
//			System.out.println(node);
			node = node.getNext();
		}
	}
	
	public static void partition (Node<Integer> head, int part)
	{
		Node<Integer> leftSide = null;
		if(head.getVal() < part)
			leftSide = head;
		
		Node<Integer> node = head.getNext();
		while(node != null)
		{
			System.out.println(node);
			if(node.getVal() < part)
			{
				Node<Integer> removed = remove(head, node);
				if(leftSide == null)
				{
					leftSide = removed;
					removed.setNext(head);
				}
				else
				{
					removed.setNext(leftSide.getNext());
					leftSide.setNext(removed);
				}
				
			}
			node = node.getNext();
		}
		
		
	}

	private static Node<Integer> remove(Node<Integer> head, Node<Integer> node) 
	{
		// TODO Auto-generated method stub
		Node<Integer> n = head;
		Node<Integer> prev = null;
		while(n.getNext() != null && n != null)
		{
			if(n.getVal() == node.getVal())
			{
				prev.setNext(n.getNext());
				return n;
			}
			prev = n;
			n = n.getNext();
		}
		
		return null;
	}
}
