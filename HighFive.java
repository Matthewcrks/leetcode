/*
Problem:
Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
*/

// Approach:
    // going to use a hashmap and a pq
    // the hashmap will have key = id
    // value = pq<integer>
    // at the end, iterate thru hashmap + calculate the average of the values in the pq


// STATISTICS:
// Runtime: > 89% of submissions

class Solution {
    public int[][] highFive(int[][] items) 
    {
        
        int tempID = 0;
        int tempScore = 0;
        int tempAverage = 0;
        HashMap<Integer, PriorityQueue<Integer>> topFive = new HashMap<Integer, PriorityQueue<Integer>>();
        PriorityQueue<Integer> tempQ = new PriorityQueue<Integer>();

        
        for(int i = 0; i < items.length; i++)
        {
            tempID = items[i][0];
            tempScore = items[i][1];
            if(!topFive.containsKey(tempID))
            {
                PriorityQueue<Integer> tempNew = new PriorityQueue<Integer>();
                
                tempNew.add(tempScore);
                topFive.put(tempID,tempNew);
            }
            else
            {
                tempQ = topFive.get(tempID);
                tempQ.add(tempScore);
                if(tempQ.size() > 5)
                {
                    tempQ.poll();  
                }
                topFive.replace(tempID,tempQ);
            }
        }
        
        int [][] averages = new int[topFive.size()][2];
        
        for (HashMap.Entry<Integer, PriorityQueue<Integer>> entry : topFive.entrySet())
        {
            tempID = entry.getKey();
            tempAverage = 0;
            tempQ = entry.getValue();
            while(!tempQ.isEmpty())
            {
                tempAverage += tempQ.poll();;
            }
            tempAverage /= 5;
            averages[tempID-1][0] = tempID;
            averages[tempID-1][1] = tempAverage;
            
        }
        
        return averages;
        
    }
}