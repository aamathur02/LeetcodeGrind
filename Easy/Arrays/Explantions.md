# Explantions for LeetCode Easy Arrays Set

## Remove Duplicates from sorted array

Uses a two pointer approach. 
1. compare pointer i and j: if they are the same, incremnet pointer j by 1   
    *  if pointer i and j are not the same, increment pointer i by 1 and set the value of nums[i] to be nums[j]   
        * right now pointer j is the next unique element   
        * so we are increment pointer i and set that to be pointer j   
        * therfore, the value after our original pointer i is the next unqie value    



## Highest profit margin II

1. Lot more simple than we think:   
    * initialize a int variable to keep track of profit
    * Iterate through array starting at index 1
        * if the current element is bigger than the previous element, add the difference to the profit variable    
    * return profit variable     

2. For python: can use the max function to determine what to add to the profit variable     
    * inside the for loop, do proft += max(prices[i] - prices[i-1], 0)     
        * finds the max of difference between two indeces, whichever is greater is added to profit
        * either adds 0 if difference is negative adds the positive difference

## Rotate Array   

Solution is O(n) runtime and O(1) memory usage

1. First rotate the whole array    
2. Then, rotate the first k elements   
3. Then rotate the elements after the first k elements

Requires an accessory rotate function:
1. Input is the array, start index, and end index
2. Use a while loop and switch end and start index   
    * condition is while start < end
3. Increment start and decrement end

For Python:
1. set self module for k    
2. for loop from 0 to k
3. add last element to front of element using insert()
4. remove last element from list using pop(-1)
