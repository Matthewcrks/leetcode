// Problem: Given two arrays, write a function to compute their intersection.


// Faster than > 90% of online submissions
// My main goal was to keep everything in O(n) even if it meant 3 separate loops


class Solution 
{
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        HashMap<Integer,Boolean> seen = new HashMap<Integer,Boolean>();
        ArrayList<Integer> intersection = new ArrayList<Integer>();
        
        for(int i = 0; i < nums1.length; i++)
        {
            if(!seen.containsKey(nums1[i]))
            {
                seen.put(nums1[i],true);
            }
        }
        
        for(int j = 0; j < nums2.length; j++)
        {
            if(seen.containsKey(nums2[j]))
            {
                intersection.add(nums2[j]);
                seen.remove(nums2[j]);
            }
        }

        int[] result = new int[intersection.size()]; 
        for(int m = 0; m < intersection.size(); m++)
        {
            result[m] = intersection.get(m);
        }
        
        return result;
        
    }
}