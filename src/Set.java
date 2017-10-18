
public class Set<T>
{
	private Object[] data;
	private final int DEFAULT_SIZE = 10;
	private final int GROWTH = DEFAULT_SIZE/2;
	private int size;
	
	public Set()
	{
		data = new Object[DEFAULT_SIZE];
		size = 0;
	}
	
	private Object[] growArray(int growth)
	{
		Object[] newArr = new Object[data.length + growth];
		for (int i = 0; i < size; i++)
			newArr[i] = data[i];
		
		return newArr;
	}
	
	public boolean add(Object obj)
	{
		if(contains(obj))
			return false;
		
		if(data.length-size < GROWTH)
			data = growArray(GROWTH);
		
		data[size] = obj;
		size++;
		return true;
	}
	
	public boolean add(int index, Object obj)
	{
		if(contains(obj))
			return false;
		
		if(index > size)
			throw new ArrayIndexOutOfBoundsException();
		
		if(data.length-size < GROWTH)
			data = growArray(GROWTH);
		
		for (int i = size-1; i >= index; i--)
			data[i+1] = data[i];
		
		data[index] = obj;
		size++;
		return true;
	}
	
//	public Object remove()
//	{
//		Object obj = data[size];
//		size--;
//		
//		if(data.length-size >= GROWTH*2)
//			data = growArray(-GROWTH);
//		
//		return obj;
//			
//	}
	
	public Object remove(int index)
	{
		if(index > size)
			throw new ArrayIndexOutOfBoundsException();
		
		Object obj = data[index];

		for (int i = index; i < size; i++)
			data[i] = data[i+1];
		
		size--;
		if(data.length-size >= GROWTH*2)
			data = growArray(-GROWTH);
		
		return obj;
	}

	
	private int searchByObject(Object obj)
	{
		for (int i = 0; i < size; i++)
		{
			if(data[i].equals(obj))
				return i;
		}
		
		return -1;
	}
	public Object remove(Object obj)
	{
		int index = searchByObject(obj);
		if(index != -1)
			return remove(index);
		else
			return null;
	}
	
	public Object get(int index)
	{
		if(index > size)
			throw new ArrayIndexOutOfBoundsException();
		
		return data[index];
	}
	
	public Object set(int index, Object obj)
	{
		if(index > size)
			throw new ArrayIndexOutOfBoundsException();
		
		Object oldObj = data[index];
		data[index] = obj;
		return oldObj;
	}
	
	public boolean contains (Object obj)
	{
		return searchByObject(obj) != -1;
	}
	
	public void clear()
	{
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		if(size == 0)
			return "[]";
		
		String s = "[";
		for(int i = 0; i < size-1; i++)
			s += data[i] + ", ";
		s += data[size-1] + "]";
		
		return s;
	}
}

