# Explantions from Leetcode Easy Strings Set

## Reverse String

### Java O(n) time and O(1) space
1. Create two pointer, one at zero and one at last index of array
2. Use while loop and switch elements at start and end index
3. Increment start and decrement end pointer

### Python 
1. Use the reverse() method

## Reverse Integer

### Java (O(log(x))) time and O(1) space
1. Use push and pop operations to remove and add integers to the result
2. Need to check for integer overflow 

### Python 
1. Same code and logic
    * REMEMBER TO USE // FOR FLOOR DIVISION

## First Unique Char

### Java-1 O(n) time and O(1) space
1. Create an array of length 26
2. Iterate through the input string and increment the appropriate value in the array
    * use the current char - 'a' to inly increment at the slot in the array reserved for the current char
3. Iterate through input string again
    * check if the value of the char at the respective array index if 1
        * if yes, return the current index in the INPUT STRING, NOT THE ALPHABET ARRAY

### Java-2 O(n) time and O(1) space
1. Create a hashmap<Character, Integer>
2. Iterate through input string and increment value and update hashmap accoridngy
3. Iterate though input string again:
    * if hashmap entry for char in string is 1, then return index value of INPUT STRING corresponding to that char

### Python 
1. create a counter 
2. iterate through the counter and if the count for the char is 1, return the index

## Valid Anagram

### Java 
1. create an array of type int of length 26
2. given that both strings are same length, create for loop for first string
3. increment respective char value from first string
4. decrement respective char value from second string
5. iterate through int[] array and if any of the values are not equal to zero, then return false
6. at end, return true