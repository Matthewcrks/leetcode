/*Problem: There are N students in a class. Some of them are friends, while some are not. 
Their friendship is transitive in nature. 
For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. 
And we defined a friend circle is a group of students who are direct or indirect friends.
Given a N*N matrix M representing the friend relationship between students in the class. 
If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
And you have to output the total number of friend circles among all the students. */

/* Approach: 
    - create an array that is a pointer to the head of each friendgroup
    - iterate thru the adjacency matrix
        - whenever you find a direct friendship, update the value at j of heads to be the same as that of heads[i]
            - NOTE: must update all of the values of head that have same head pointer as head[j]
        - at the end, iterate thru the heads array, finding how many unique head pointers there are
*/

class Solution 
{
    public int findCircleNum(int[][] M) 
    {
        HashMap<Integer,Boolean> unique = new HashMap<Integer,Boolean>();
        int count = 0;
        int size = M[0].length;
        int [] heads = new int[size];
        int temp = 0;
        
        //initialize all of the values inside of head
        for(int init = 0; init < heads.length; init++)
        {
            heads[init] = init;
        }
        
        
        for(int i = 0; i < size; i++)
        {
            for(int j = i+1; j < size; j++)
            {
                if(M[i][j] == 1)
                {
                    temp = heads[j];
                    for(int counter = 0; counter < size; counter++)
                    {
                        
                        if(heads[counter] == temp)
                        {
                            heads[counter] = heads[i];
                        }
                        
                    }
                }
            }
        }
        
        //iterate thru heads calculating the # of unique values
        for(int m = 0; m < heads.length; m++)
        {
            if(!unique.containsKey(heads[m]))
            {
                unique.put(heads[m],true);
                count++;
            }
            else
                continue;
        }
        
        return count;
        
    }
}