// Problem: Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

// Solution: Faster than 100% of online submissions

class Solution 
{
    public boolean isPowerOfFour(int num) 
    {

        if (num == 0)
        {
            return false;    
        } 
        while (num % 4 == 0)
        {
            num = num/4;
        }

        
        return num == 1;
        
    }
}