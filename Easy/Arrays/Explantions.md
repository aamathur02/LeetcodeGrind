# Explantions for LeetCode Easy Arrays Set

## Remove Duplicates from sorted array

Uses a two pointer approach. 
    * compare pointer i and j: if they are the same, incremnet pointer j by 1   
    *  if pointer i and j are not the same, increment pointer i by 1 and set the value of nums[i] to be nums[j]   
        * right now pointer j is the next unique element   
        * so we are increment pointer i and set that to be pointer j   
        * therfore, the value after our original pointer i is the next unqie value    



    