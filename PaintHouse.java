//Problem:
/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... 
Find the minimum cost to paint all houses.
*/

// My Solution:
// Runtime > 69% of all online submission
// Memory usage < 58% of all online submissions


class Solution 
{
    public int minCost(int[][] costs) 
    {
        // DP: approach using 2d array with dimensions n x 3
        // at dp[i][j], will hold the min.cost of painting the ith house with color j
        
        if(costs == null || costs.length == 0)
        {
            return 0;
        }
        
        int [][] dp = new int[costs.length][3];
        
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i = 1; i < dp.length; i++)
        {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
        }
        
        int finalMinimum = dp[costs.length-1][0];
        
        //check the final row to find the overall minimum
        for(int j = 1; j < 3; j++)
        {
            if(dp[costs.length-1][j] < finalMinimum)
            {
                finalMinimum = dp[costs.length-1][j];
            }
        }
        
        return finalMinimum;
        
        
    }
}