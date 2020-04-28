/**
* @author Ferruccio Sisti
* @since April 27, 2020
* Problem:
* Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
* its entire row and column are set to 0.
*/

import java.util.*;

public class ZeroMatrix
{
    public static void main(String args[])
    {
        //test
        int test[][] = new int[][]{{0, 1, 2}, {3, 0, 5}, {9, 9, 9}};
        zeroify(test);
    }

    /**
    * @param matrix the matrix we will be altering
    * @return the altered matrix with rows and columns of 0's
    */
    public static int[][] zeroify(int[][] matrix)
    {
        //Try it using an arraylist of arrays (size 2)
        List<int[]> zerocoords = new ArrayList<int[]>();

        //go through the matrix and find any occurances of 0, add the coordinates to a list
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                //if there is a 0 then add its coordinate to the list
                if(matrix[i][j] == 0)
                {
                    int[] coords = new int[]{i, j};
                    zerocoords.add(coords);
                }
            }
        }

        //go through each pair in the list and make corresponding rows/columns full of 0's
        for(int[] c: zerocoords)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                //change the column to 0's
                matrix[i][c[0]] = 0;
            }
            for(int i = 0; i < matrix[0].length; i++)
            {
                //change the row to 0's
                matrix[c[1]][i] = 0;
            }
        }
        /**
        Another solution to this problem would be creating an array of equal size to the
        input but as a boolean array and initializing everything to false. Then iterate
        through the given array and make the occurance of a 0 element true in the bool array.
        You can then iterate through the bool array after and do your replacing based on that.
        I started doing this method that way before finding my own solution as above.


        //create another array of booleans the same size as the array we are replacing 0s in
        Boolean[][] arrcp = new Boolean[matrix.length][matrix[0].length];

        //can't simply use Arrays.fill() because its a multidimensional array
        for (Boolean[] row: arrcp)
        {
            //fill each row individually
            Arrays.fill(row, false);
        }
        System.out.println(Arrays.deepToString(arrcp));

        //nested for loop to check each element of the array for zero's
        //and mark it in the boolean copy array
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    arrcp[i][j] = true;
                }
            }
        } */

        return matrix;
    }
}
