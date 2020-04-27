/**
* @author Ferruccio Sisti
* @since April 22, 2020
* Problem:
* Rotate Matrix: Given an image represented by an NxN matrix, where each pixel
* in the image is 4 bytes, write a method to rotate the image by 90 degrees.
* Can you do this in place?
*/

import java.util.Arrays;

public class RotateMatrix
{
    public static void main(String argsp[])
    {
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //test the method
        System.out.println(Arrays.deepToString(test));
        System.out.println("\n" + rotateImage(test));
    }

    /**
    * @param image the matrix representing the image you want to rotate 90%
    * @return a boolean true or false if rotation in place succeeds or not
    */
    public static Boolean rotateImage(int[][] image)
    {
        //if our matrix has a size of 0, or is not a square, we cannot rotate it
        if (image.length == 0 || image[0].length != image.length)
        {
            return false;
        }

        int first, last, offset, top;

        //do layer by layer swapping (layer is the first column)
        for(int layer = 0; layer < image.length / 2; layer++)
        {
            first = layer;
            last = image.length - layer - 1;

            //do the swapping rotation
            for(int i = first; i < last; i++)
            {
                //create an offset
                offset = i - first;

                //rotations
                top = image[first][i]; //top
                image[first][i] = image[last - offset][first]; //put left in top
                image[last - offset][first] = image[last][last - offset]; //put bottom to left
                image[last][last - offset] = image[i][last]; //put right to bottom
                image[i][last] = top;
            }
        }
        //if method makes it this far then return true
        System.out.println(Arrays.deepToString(image));
        return true;
    }
}
