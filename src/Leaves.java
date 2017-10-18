import java.util.PriorityQueue;
import java.util.Scanner;

public class Leaves 
{
    public static class TreeNode implements Comparable<TreeNode>
    {
       public int value;
       public TreeNode left;
       public TreeNode right;
       public TreeNode parent;
       public int cost;
       public int level;
       
       public TreeNode(int initValue, int k, int l) 
       {
          value = initValue;   left = null;   right = null; parent = null; cost = k; level = l;
       }

	@Override
	public int compareTo(TreeNode o) {
		if (this.cost > o.cost)
			return 1;
		else if (this.cost < o.cost)
			return -1;
		else{
			if (this.level < o.level)
				return -1;
			else if (this.level > o.level)
				return 1;
			else
				return Integer.compare(this.value, o.value);
				
		}
//		return this.cost - o.cost;
	}
	
	public String toString () {
		return "" + value;
	}
    }
   
    public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);
    	int testC = s.nextInt();
    	while(--testC >= 0)
    	{
    		int leaves = s.nextInt();
    		TreeNode root = new TreeNode(s.nextInt(), 0, 0);
    		PriorityQueue<TreeNode> q = new PriorityQueue<TreeNode>();
    		q.add(root);
    		for(int i = 1; i < leaves; ++i)
    		{
    			int leaf = s.nextInt();
    			TreeNode value = new TreeNode(leaf, 0, 0);
    			insert (root, value);
    			q.add(value);
    		}
    		
//    		inorder (root);
//    		System.out.println();
    		while (!q.isEmpty())
    		{
    			if(q.size() == 1)
    				System.out.print(q.poll());
    			else
    				System.out.print(q.poll()+ " ");

    		}
    		System.out.println();
    		
    	}
    }
    
    public static void inorder(TreeNode node) 
    {
       if (node == null) return;
    	
       System.out.print(node.value+ "  " + node.cost + ", ");
 	      inorder(node.left);
 	      inorder(node.right);
    }
    
    private static void insert(TreeNode node, TreeNode value)
    {
// 	   if(node == null)
// 	   {
// 		   root = value;
// 		   return;
// 	   }
 	   
 	   if(node.value > value.value)
 	   {
 		   if(node.left == null)
 		   {
 			   node.left = value;
 			   value.cost = node.cost - 1; //we changed it experiment
 			   value.level = node.level +1;
 			   value.parent = node;
 		   }
 		   else
 			   insert(node.left, value);
 	   }
 	   else
 	   {
 		   if(node.right == null)
 		   {
 			   node.right = value;
 			   value.cost = node.cost + 1;
 			  value.level = node.level + 1 ;
 			   value.parent = node;
 		   }
 		   else
 			   insert(node.right, value);	   
 	   }
    }

}
