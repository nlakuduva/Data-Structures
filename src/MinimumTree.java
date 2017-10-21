import DataStructures.TreeNode;

public class MinimumTree 
{
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5};
		TreeNode<Integer> node = createMinTree(arr);
		postOrder(node);
		
	}
	
	public static TreeNode<Integer> createMinTree(int[] arr)
	{
		return createMinTreeHelper(arr, 0, arr.length-1);
	}
	
	private static void postOrder(TreeNode<Integer> node)
	{
		if (node == null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.getValue());

	}

	private static TreeNode<Integer> createMinTreeHelper(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(end < start)
			return null;
		
		int mid = (start+end)/2;
		TreeNode<Integer> node = new TreeNode<Integer>(arr[mid]);
		
		node.setLeft(createMinTreeHelper(arr, start, mid-1));
		node.setRight(createMinTreeHelper(arr, mid+1, end));
		
		return node;
	}

}

