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


## Contains Duplicate

### Java O(n) time and O(n) space
1. Use a hashset of same length as array and iterate through the array using for loop       
2. If the set contains the number, return true
3. else add the number to set
3. return false outside for loop


### Python O(n) time and O(n) space
1. Create a set from the array
2. Compare the length of the set and the length of the array
3. if the length of the set of lower, retun true
    * works on principle that sets have no duplicates so if there are duplicates, then the length of the set must be lower than the List


## Single Number

### Java and Python O(n) time and O(1) space
1. does some bit manipulation black magic

1. Otherwise can use a hashmap and return value w key 1 at the end

## Intersection of two array II

### Java
1. Create hashmap and iterate through array1 and update the values and keys to match array1 occurences
    * can use map.getOrDefault to avoid if statements
2. Create empty arraylist
3. Iterate through array2 and see if hashmap has number:
    * if hashmap has number, add number to arraylist and decrement count of number in hashmap
4. Convert arraylist to array and return

### Python
1. Create Counter objects for both lists
    * this keep track of count of each int, basically like a hashmap
2. iterate through counter1 and see if counter2 also has the same number
    * if so, create a cout variable and set it to the min of the occurence of the num in counter 1 and 2
3. add the number to an empty list "count" times
4. return this list

## Plus One

### Java
1. Iterate from the end to the front of the array
    * if the element at the current index is less than 9, increment it by 1 and then return the array
    * else, set the element to 0 and then move on the next index
2. If the method doesnt return before the while loop ends, that means the array had all 9's in it
    * make a new array with length + 1 of the input array
    * set the first element to 1 and the rest are automatically zero
3. return this newly formed array

### Python
1. Same thing but can do reversed(range(....)) to go from front to back
2. For edge case, can just do some list add and multiply as opposed to creating a new list

## Two Sum

### Java O(n) time and space
1. Create a hashmap of <Integer, Integer>
    * the basic schema is that the key will be the value of the elements in the input array and the value will be the index of that element     
2. Iterate through the array with a for loo
3. If the map contains the complement, return an array with the value of the hashmap entry with the complement and the current index
4. Outside the if, but inside the for loop, add the element to the hashmap as the key and the index as the value

### Python
1. iterate from beginning to end of list
2. calculate complement for given element
3. Check if conmplement is in the array and that the compliment is not just the same element
4. then return a list with the current index and index of compliment

## Valid Sudoku

### Java O(1) time and space
1. Idea is to create three arrays of HashSet<Character> - length of each array is 9
    * The three arrays correspond to row, columns, and boxes
    * Each HashSet represents the entries within each indiviudal box, column, row
    * The length is 9 because there are 9 rows, 9 columns, 9 boxes
2. For loop to initialize an empty HashSet in each array
3. Create a nested for loop from 0 to 9 and then 0 to 9 again
    * idea is to use nested for loop to iterate from beginning of board to end as it is represented as a 2d array
4. Get the char at the location in the board and check if the char is a number and not '.'
5. Use special equation to get boxNumber
6. See if the char already exists in any of the HashSets ==> if yes, return false
    * utilize the put() methid for hashsets 
        * returns false if element already exists in hashset
    * use rows[i] and columns[j] and boxes[boxNumber] to check in right HashSet within array
7. Outside nested for, return true ==> none of out if clauses caught to sudoko is valid


### Python
Same logic as java but a few different things
1. Use list of dicts instead of array of hashset
    * the key is the actual number on the board, and the value is its occurence ==> means we need to explicetaly check of value is greater than 1 rather than rely on properties of a set
2. Instead of using the put() method, which returns a boolean, to see if there is a duplicate, we need to explicetaly add the value to our list of dicts
3. After adding, if the value of any of the numbers is greater than 1, we return false

    

