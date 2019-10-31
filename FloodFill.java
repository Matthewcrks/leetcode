// Problem:
/* An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image. */

// Approach:
// Utilize a dfs approach that is similar to the island dfs problem
// utilize recursion to expand outwards from a singular spot


// Submission: faster than 88% of all online java submissions
// uses less memory than 55% of online java submissions




class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        // to me this seems like another DFS / connected components kind of thing
        // reminds me of the island problem
        int startColor = image[sr][sc];
        int [][] result = new int[image.length][image[sr].length];
        
        if(startColor == newColor)
        {
            return image;
        }
        
        dfs(image,sr,sc,startColor,newColor);
        
        return image;
        
    }
    
    public void dfs(int [][] image, int sr, int sc, int startColor, int newColor)
    {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != startColor)
        {
            return;
        }
        
        image[sr][sc] = newColor;
        dfs(image,sr-1,sc,startColor,newColor);
        dfs(image,sr+1,sc,startColor,newColor);
        dfs(image,sr,sc-1,startColor,newColor);
        dfs(image,sr,sc+1,startColor,newColor);
    }
}