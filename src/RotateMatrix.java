
public class RotateMatrix 
{
	public static void main(String[] args)
	{
		int[][] matrix=new int[10][10];
		int count = 0;
		for(int row=0;row<matrix.length;++row)
		{
			for(int col=0;col<matrix[row].length;++col)
			{
				matrix[row][col]= row*matrix.length + col + 1;
			}
		}
		
		rotateMatrix2(matrix);
		for(int row=0;row<matrix.length;row++)
		{
			for(int col=0;col<matrix[row].length;col++)
			{
				System.out.print(matrix[row][col]+"\t");
			}
			System.out.println();
		}
	}
	
    public static int[][] rotateMatrix(int[][] matrix)
    {
    	int[][] newM = new int[matrix.length][matrix[0].length];
    	for(int i = 0; i < matrix.length; i++)
    	{
    		for (int j = 0; j < matrix[0].length; j++)
    		{
    			int val = matrix[i][j];
    			int newCol = matrix.length-1-i;
    			newM[j][newCol] = val;
    		}
    	}
    	
    	return newM;
    }
    
    public static void rotateMatrix2(int[][] matrix)
    {
    	for(int i = 0; i < matrix.length/2; i++)
    	{
    		for (int j = i; j < matrix[0].length-j-1; j++)
    		{
    			int row = i;
    			int col = j;
    			int val = matrix[row][col];
    			do
    			{
    				int old = matrix[col][matrix.length-1-row];
        			matrix[col][matrix.length-1-row] = val;
        			row = col;
        			col = matrix.length-1-row;
        			val = old;
    			}
    			while(row != i && col != j);

    		}
    	}
    	
    }

}
