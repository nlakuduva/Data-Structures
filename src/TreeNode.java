
public class TreeNode<T extends Comparable<? super T>> 
{
   public T value;
   public TreeNode<T> left;
   public TreeNode<T> right;
   private TreeNode<T> parent;
   
   public TreeNode(T initValue) 
   {
      value = initValue;   left = null;   right = null; parent = null;
   }
   
   public TreeNode(T initValue, TreeNode<T> initLeft,
         TreeNode<T> initRight) 
   {
      value = initValue;  left = initLeft;  right = initRight; parent = null;
   }

   public T getValue() { return value; }
   public TreeNode<T> getLeft() { return left; }
   public TreeNode<T> getRight() { return right; }
   public TreeNode<T> getParent() { return parent; }
   
   public void setValue(T theNewValue) 
   {   value = theNewValue; }

   public void setLeft(TreeNode<T> theLeft) 
   {   left = theLeft; }

   public void setRight(TreeNode<T> theRight) 
   {   right = theRight; }
   
   public void setParent(TreeNode<T> theParent) 
   {   parent = theParent; }
   
   

} 
