
public class Node<T>
{
	public T val;
	public Node<T> next;
	public Node<T> previous;
	
	public Node(T value)
	{
		val = value;
		next = null;
		previous = null;
	}
	
	public T getVal()
	{
		return val;
	}
	
	public Node<T> getNext()
	{
		return next;
	}
	
	public void setNext(Node<T> n)
	{
		next = n;
		
	}
	
	public Node<T> getPrevious()
	{
		return previous;
	}
	
	public void setPrevious(Node<T> n)
	{
		previous = n;
		
	}
	
	public void setVal(T value)
	{
		val = value;
	}

}
