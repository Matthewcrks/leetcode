// Problem: Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

/* Approach: 
Time: O(n), Space: O(1)
	- use DP / karane's algo to maintain a local and global maximum
	- at each spot there are two cases, for finding the local maximum
		1. current index is largest
		2. current index + current local maximum
	- if the local max > global then reset the global
*/



class Solution
{
	public int maxSubArray(int[] nums)
	{
		Integer max = Integer.MIN_VALUE;
		int localMax = nums[0];

		for(int i = 0; i < nums.length; i++)
		{
			if(i == 0)
			{
				max = localMax;
				continue;
			}

			localMax = Math.max(nums[i],localMax = nums[i]);
			if(localMax > max)
			{
				max = localMax;
			}
		}

		return max;

	}
}