/*
  File: Grid.java

  Description:find the greatest product of four adjacent numbers in the same direction(horizontal, vertical, or diagonal)
  				in a grid of positive integers.

  Student Name:Alexandra Scott

  Student UT EID:aks2936

  Partner Name:

  Partner UT EID:

  Course Name: CS 312

  Unique Number: 87525

  Date Created:08/3/2016

  Date Last Modified:08/04/2016

*/

import java.util.*;
import java.io.*;

public class Grid
{
	
	public static void main(String[] args) throws IOException
	{	//create file object
		File inFile = new File("src/grid.txt");

		Scanner input = new Scanner (inFile);
		
		//the first line is the dimensions of the grid
		String dimension = input.nextLine().trim();
		int num = Integer.parseInt(dimension);

		//create a 2D array to store the grid
		int[][] gridArray = new int [num][num];
		
		//read through file and add to the 2-D array
 		for(int i =0; i<num; i++)
 		{
 			String line = input.nextLine();

 			String[] len = line.split("\\s+");
			Integer[] dimensions = new Integer[len.length];

			for (int a = 0; a < len.length; a++)
			{
				dimensions[a] = Integer.parseInt(len[a]);
			}
				for(int b =0; b < num; b++)
				{
	   				gridArray[i][b] = dimensions[b];
	   			}
		}
		
		input.close();

		int product = 0;
		int max = 0;
		// Check horizontal
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 17; j++)
            {
                product = gridArray[i][j] * gridArray[i][j + 1] * gridArray[i][j + 2] * gridArray[i][j + 3];
                if(product > max)
                {
                    max = product;
                }
            }   
        }
         
        // Check vertical
        for(int i = 0; i < 17; i ++)
        {
            for(int j = 0; j < 20; j++)
            {
                product = gridArray[i][j] * gridArray[i + 1][j] * gridArray[i + 2][j] * gridArray[i + 3][j];
                if(product > max)
                {
                    max = product;
                }
            }
        }
         
        // Check right diagonal 
        for(int i = 0; i < 17; i++)
        {
            for(int j = 0; j < 17; j++)
            {
                product = gridArray[i][j] * gridArray[i + 1][j + 1] * gridArray[i + 2][j + 2] * gridArray[i + 3][i + 3];
                if(product > max)
                {
                    max = product;
                }
            }
        }
         
        // Check left diagonal
        for(int i = 0; i < 17; i ++)
        {
            for(int j = 3; j < 20; j ++)
            {
                product = gridArray[i][j] * gridArray[i + 1][j - 1] * gridArray[i + 2][j  - 2] * gridArray[i + 3][j - 3];
                if(product > max)
                {
                    max = product;
                }
            }
        }
		System.out.println("The greatest product is " + max + ".");

	}

	 
	

}
