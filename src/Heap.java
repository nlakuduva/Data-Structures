
public class Heap<T extends Comparable<? super T>> extends Tree<T>
{
	private TreeNode<T> root;
	private int size;
	
	public Heap()
	{
		root = null;
		size = 0;
	}
	
	public Heap(TreeNode<T> node)
	{
		root = node;
		size = 1;
	}
	
	public TreeNode<T> getRoot()
	{
		return root;
	}
	
	public void insert(T value)
    { 
	   insert(root, new TreeNode<T>(value));
    }
	
	private void insert(TreeNode<T> node, TreeNode<T> value)
	{
		if(root == null)
		{
			root = value;
			return;
		}
		
		/* insert using Breadth-first-search (queue to the rescue!) */
	    Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
	    queue.push(root);
	    //boolean bool = true;

	    while(true) 
	    {
	    	TreeNode<T> n = queue.pop();
//	        if(!n.visited) System.out.println(n.data);
//	        n.visited = true;

	        if(n.getLeft() == null) 
	        {
	            n.setLeft(value);
	            break;
	            //bool = false;
	        } 
	        else 
	            queue.push(n.getLeft());       

	        if(n.getRight() == null) 
	        {
	            n.setRight(value);
	            break;
	            //bool = false;
	        } 
	        else
	            queue.push(n.getRight());
	    }
	    sort(root);
	}

	public void sort(TreeNode<T> root)
	{
		
	}
	public void printOut()
	{
		super.printLevelWise(root);
	}
	
}
