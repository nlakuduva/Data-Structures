package DataStructures;
import java.util.ArrayList;

public class Tree<T extends Comparable<? super T>> 
{
	private TreeNode<T> root;
	private int size;
	
	public Tree()
	{
		root = null;
		size = 0;
	}
	
	public Tree(TreeNode<T> node)
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
	   if(node == null)
	   {
		   root = value;
		   size++;
		   return;
	   }
	   
	   if(value.getValue().compareTo(node.getValue()) <= 0)
	   {
		   if(node.getLeft() == null)
		   {
			   node.setLeft(value);
			   value.setParent(node);
			   size++;
		   }
		   else
			   insert(node.getLeft(), value);
	   }
	   else
	   {
		   if(node.getRight() == null)
		   {
			   node.setRight(value);
			   value.setParent(node);
			   size++;
		   }
		   else
			   insert(node.getRight(), value);	   
	   }
   }
   
   
	public TreeNode<T> search(T value)
    { 
	   return search(root, value);
    }
	   
   private TreeNode<T> search(TreeNode<T> node, T value)
   {
	   if(node.getValue().compareTo(value) == 0)
		   return node;
	   
	   if(value.compareTo(node.getValue()) < 0)
	   {
		   if(node.getLeft() == null)
			   return null;
		   else
			   return search(node.getLeft(), value);
	   }
	   else
	   {
		   if(node.getRight() == null)
			   return null;
		   else
			   return search(node.getRight(), value);	   
	   }
   }
   
   public TreeNode<T> remove(T value)
   {
	   return remove(root, value);
   }
   
   private TreeNode<T> remove(TreeNode<T> root, T value)
   {
	   TreeNode<T> node = search(root, value);
	   if(node == null)
		   return null;

	   //if node to be removed does not have children
	   if(node.getLeft() == null && node.getRight() == null)
	   {
		   TreeNode<T> parent = node.getParent();
		   //if node is the root --> delete root
		   if (parent == null)
		   {
			   root = null;
			   size--;
			   return node;
		   }
		   //else tell parent to not point to it anymore
		   if(parent.getRight().getValue().compareTo(value) == 0)
			   parent.setRight(null);
		   else
			   parent.setLeft(null);
	   }
	   else
	   {
		   TreeNode<T> parent = node.getParent();
		   TreeNode<T> child;
		   TreeNode<T> sibling;
		   
		   //decide which child to replace the parent with
		   if(node.getLeft() == null)
		   {
			   child = node.getRight(); 
			   sibling = node.getLeft(); 
		   }
		   else
		   {
			   child = node.getLeft(); 
			   sibling = node.getRight(); 
		   }
		   
		   //is the root
		   if (parent == null)
		   {	   
			   child.setParent(parent);
			   this.root = child;
			   if(sibling != null)
				   insert(this.root, sibling);
		   }
		   else 
		   {
			   //determine if left or right child
			   boolean right;
			   if(parent.getRight().getValue().compareTo(node.getValue()) == 0)
				   right = true;
			   else
				   right = false;
				   
			   child.setParent(parent);
			   if(right == true)
				   parent.setRight(child);
			   else
				   parent.setLeft(child);			   
			   if(sibling != null)
				   insert(root, sibling);
		   }
	   }
		
	size--;
	return node;
		   
   }
   
   public int size()
   {
	   return size;
   }
   
   public void inorder(TreeNode<T> node) 
   {
      if (node == null) return;
   	
      System.out.print(node.getValue() + "  ");
	      inorder(node.getLeft());
	      inorder(node.getRight());
   }
   
   public void printOut()
   {
	   printLevelWise(root);
   }

   private LinkedList<LinkedList<TreeNode<T>>> traverseLevels(TreeNode<T> root) {
	    if (root == null) {
	        return new LinkedList<LinkedList<TreeNode<T>>>();
	    }
	    LinkedList<LinkedList<TreeNode<T>>> levels = new LinkedList<LinkedList<TreeNode<T>>>();

	    Queue<TreeNode<T>> nodes = new Queue<TreeNode<T>>();
	    nodes.push(root);

	    while (!nodes.isEmpty()) {
	        LinkedList<TreeNode<T>> level = new LinkedList<TreeNode<T>>();
	        levels.add(level);

	        ArrayList<TreeNode<T>> temp = new ArrayList<TreeNode<T>>();
	        int count = 0;
	        while(count != nodes.getSize())
	        {
	        	temp.add(nodes.peek());
	        	nodes.push(nodes.pop());
	        	count++;
	        }
	        
	        for (TreeNode<T> node : temp) {
	            level.add(node);
	            if (node.getLeft() != null) {
	                nodes.push(node.getLeft());
	            }
	            if (node.getRight() != null) {
	                nodes.push(node.getRight());
	            }
	            nodes.pop();
	        }
	    }
	    return levels;
	}
	
	public void printLevelWise(TreeNode<T> root) {
		LinkedList<LinkedList<TreeNode<T>>> levels = traverseLevels(root);

	    for(int i = 0; i < levels.getSize(); i++)
	    {
	    	LinkedList<TreeNode<T>> level = levels.get(i);
	    	for(int j = 0; j < level.getSize(); j++)
	        {
	        	TreeNode<T> node = level.get(j);
	            System.out.print(node.getValue() + " ");
	        }
	        System.out.println();
	    }
	}

}
