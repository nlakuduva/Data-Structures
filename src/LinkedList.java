
public class LinkedList<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public T get(int index)
	{
		if (size == 0 || index >= size)
			return null;
		
		Node<T> n = head;
		for (int i = 1; i <= index; i++)
			n = n.getNext();
		T obj = n.getVal();
		return obj;
	}
	public boolean add(int index, T obj)
	{
		if(index > size)
			return false;
		
		if(index == 0)
			addHead(obj);
		else if (index == size)
			add(obj);
		else
		{
			Node<T> n = new Node<T>(obj);
			Node<T> prev = head;
			for (int i = 1; i < index; i++)
				prev = prev.getNext();
			n.setPrevious(prev);
			n.setNext(prev.getNext());
			prev.setNext(n);
			n.getNext().setPrevious(n);
			size++;
		}
		return true;

	}
	
	public void add(T obj)
	{
		if(head == null)
			addHead(obj);
		else
		{
			Node<T> n = new Node<T>(obj);
			n.setPrevious(tail);
			tail.setNext(n);
			tail = n;
			size++;
		}
		
	}
	
	public void addHead(T obj)
	{
		Node<T> n = new Node<T>(obj);
		if(size == 0)
		{
			head = n;
			tail = head;
		}
		else
		{
			head.setPrevious(n);
			n.setNext(head);
			head = n;
		}
		size++;
	}
	

	
	public T remove(int index)
	{
		if (size == 0 || index >= size)
			return null;
		else if (index == 0 || size == 1)
			return removeHead();
		else if (index == size-1)
			return remove();
		else
		{
			Node<T> n = head;
			for (int i = 1; i <= index; i++)
				n = n.getNext();
			T obj = n.getVal();
			n.getPrevious().setNext(n.getNext());
			n.getNext().setPrevious(n.getPrevious());
			size--;
			return obj;
		}
		
	}
	
	public T remove()
	{
		if (size == 0)
			return null;
		else if (size == 1)
			return removeHead();
		else
		{
			T obj = tail.getVal();
			tail.getPrevious().setNext(null);
			tail = tail.getPrevious();
			size--;
			return obj;
		}
	}
	
	public T removeHead()
	{
		if (size == 0)
			return null;
		else if(size == 1)
		{
			T obj = head.getVal();
			head = null;
			tail = null;
			size--;
			return obj;
		}
		else
		{
			T obj = head.getVal();
			head.getNext().setPrevious(null);
			head = head.getNext();
			size--;
			return obj;
		}	
	}
	

	
	public T set(int index, T obj)
	{
		if (size == 0 || index >= size)
			return null;
		
		Node<T> n = head;
		for (int i = 1; i <= index; i++)
			n = n.getNext();
		T val = n.getVal();
		n.setVal(obj);
		return val;
	}
	
	public boolean contains(T obj)
	{
		if (size == 0)
			return false;
		
		for (Node<T> n = head; n != null; n = n.getNext())
		{
			if(n.getVal().equals(obj))
				return true;
		}
		return false;
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
		s +="LinkedList: ";
		while(n != null)
		{
			s += n.getVal() + " ";
			n = n.getNext();
		}
		return s;
	}
}
