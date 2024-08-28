package assign8.com;

import java.util.Arrays;
import java.util.Scanner;

class artharrays {
	 public static Scanner s = new Scanner(System.in);
	 public static void addition(int [][] a,int [][] b)
	 {
		 int r1 = a.length;
		 int c1 = a[0].length;
		 int r2 = b.length;
		 int c2 = b[0].length;
		 int newr = r1>r2?r1:r2;
		 int newc = c1>c2?c1:c2;
		 int [][] newmat = new int[newr][newc];
		 for(int i=0;i<newr;i++)
		 {
			 for(int j =0;j<newc;j++)
			 {
				int val1 = (i<r1 && j<c1)?a[i][j]:0;
				int val2 = (i<r2 && j<c2)?b[i][j]:0;
				newmat[i][j] = val1 + val2;
			 }
		 }
		 System.out.println(Arrays.deepToString(newmat));
		 
	 }
	 public static void multiplication(int [][] a,int [][] b)
	 {
		 int r1 = a.length;
		 int c1 = a[0].length;
		 int r2 = b.length;
		 int c2 = b[0].length;
		 int [][] newmat = new int[c1][c2];
		 if(c1==r2)
		 {
		 
			
				
				for(int i =0;i<c1;i++)
				{
					for(int j =0;j<c2;j++)
					{
						int temp = 0;
						for(int k =0;k<r2;k++)
						{
							temp += a[i][k]*b[k][j];
					    }
						newmat[i][j] = temp;
				    }
			    }
				System.out.println(Arrays.deepToString(newmat));
		 }
		 else
		 {
			 System.out.println("can't multiply these two idiot matrices not possible");
		 }
	 }
	 public static void subtraction(int[][]a,int[][]b)
	 {
		 int r1 = a.length;
		 int c1 = a[0].length;
		 int r2 = b.length;
		 int c2 = b[0].length;
		 int newr = r1>r2?r1:r2;
		 int newc = c1>c2?c1:c2;
		 int [][] newmat = new int[newr][newc];
		 for(int i=0;i<newr;i++)
		 {
			 for(int j =0;j<newc;j++)
			 {
				int val1 = (i<r1 && j<c1)?a[i][j]:0;
				int val2 = (i<r2 && j<c2)?b[i][j]:0;
				newmat[i][j] = val1 - val2;
			 }
		 }
		 System.out.println(Arrays.deepToString(newmat));
	 }
	 public static void transpose(int[][]a)
	 {
		 int r1 = a.length;
		 int c1 = a[0].length;
		 int[][] newmat = new int[c1][r1];
		 for(int i =0;i<r1;i++)
		 {
			 for(int j=0;j<c1;j++)
			 {
				 newmat[j][i] = a[i][j];
			 }
		 }
		 System.out.println(Arrays.deepToString(newmat));
		 
	 }
	
	public static void main(String[] args) {
		
          System.out.println("Enter the no of rows for ur first array");
          int r1 = s.nextInt();
          System.out.println("Enter the no of coulumns for ur first array");
          int c1 = s.nextInt();
          System.out.println("Enter the no of rows for ur second array");
          int r2 = s.nextInt();
          System.out.println("Enter the no of columns for ur second array");
          int c2 = s.nextInt();
          int [][] A1 = new int[r1][c1];
          int [][] A2 = new int[r2][c2];
          for(int i =0;i<r1;i++)
          {
        	  for(int j =0;j<c1;j++)
        	  {
        		  System.out.println("enter "+(i+1)+"nd row "+(j+1)+"th column element for first Array");
        		  int temp = s.nextInt();
        		  A1[i][j] = temp;
        	  }
          }
          for(int k =0;k<r2;k++)
          {
        	  for(int l =0;l<c2;l++)
        	  {
        		  System.out.println("enter "+(k+1)+"nd row "+(l+1)+"th column element for second Array");
        		  int temp = s.nextInt();
        		  A2[k][l] = temp;
        	  }
          }
          int choice;
          do 
          {
        	  System.out.println("1.addition of both");
        	  System.out.println("2. subtraction of both");
        	  System.out.println("3. multiplication");
        	  System.out.println("4. transpose of first array");
        	  System.out.println("5. transpose of second array");
        	  System.out.println("6. exit");
        	  choice = s.nextInt();
        	  switch(choice)
        	  {
        	  case 1:
        	  {
        		  addition(A1,A2);
        		  break;
        	  }
        	  case 2:
        	  {
        		  subtraction(A1,A2);
        		  break;
        	  }
        	  case 3:
        	  {
        		  multiplication(A1,A2);
        		  break;
        	  }
        	  case 4:
        	  {
        		  transpose(A1);
        		  break;
        	  }
        	  case 5:
        	  {
        		  transpose(A2);
        		  break;
        	  }
        	  case 6:
        	  {
        		  System.out.println("bye bye blud");
        		  break;
        	  }
        	  default :
        	  {
        		  System.out.println("wrong input ahole");
        		  break;
        	  }
        	  }
          }while(choice!=6);
          
          
	}

}
