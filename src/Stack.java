public class Stack<T> 
{
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public Stack()
	{
		head = null;
		tail = head;
		size = 0;
	}
	
	public void push(T obj)
	{
		Node<T> n = new Node<>(obj);
		if(head == null)
		{
			head = n;
			tail = head;
			size++;
		}
		else
		{
			n.setPrevious(tail);
			tail.setNext(n);
			tail = n;
			size++;
			
		}
	}
	
	public T pop()
	{
		if(size == 0)
		{
			return null;
		}
		else if(size == 1)
		{
			T obj= tail.getVal();
			tail = null;
			head = null;
			size--;
			return obj;
		}
		else
		{
			Node<T> node = tail;
			Node<T> prev = node.getPrevious();
			prev.setNext(null);
			tail = prev;
			size--;
			return node.getVal();
		}
	}
	
	public T peek()
	{
		if(size == 0)
			return null;
		return tail.getVal();
	}
	
	public boolean isEmpty()
	{
		return size == 0;	
	}
	
	public int getSize()
	{
		return size;
	}
	
	public String toString()
	{
		String s = new String();
		Node<T> n = head;
		s +="Stack: ";
		while(n != null)
		{
			s += n.getVal() + " ";
			n = n.getNext();
		}
		return s;
	}
	
}
