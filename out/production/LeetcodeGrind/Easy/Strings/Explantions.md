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

## Valid Palindrome
### Java
1. create two pointers one pointing to beginning and end
2. first while loop is to use to bring pointers inwards
3. First nested while loop increments first pointer so that all the non alphanumeric chars are ignored and we go to the first alphanumeric
4. Second nested loop does the same thing, but for the end pointer
5. convert the chars at the beginning and end pointers to lowercase and if they are not the same, return false
6. increment beginning pointer and decrement ending pointer
7. Outside while loop, return true

## String to Integer

### Java
1. if input string length is zero, return 0
2. Iterate through the string until you find the first non whitespace in the string
3. Then check if that first non whitespace is a plus or minus sign and record that with a boolean
4. create another while loop and go through the numbers
    * if they break overflow, return MIN_VALUE or MAX_VALUE depending on the negative boolean value
5. Else, add that value to ten times the current return value
    * need to to s.charAt(counter) - '0' to get its numerical value as opposed to ASCII value
6. return the negative of postive value depending on the boolean


## Implement strstr, Needle In Haystack

### Python
1. If needle if empty, return 0
2. Check if needle in haystack
    * if true, return haystack.find(needle)
    * else, return -1

## Longest Common Prefix

### Java O(N) space and O(1) Time
1. If input array length if zero, retun blank string
2. Set prefix to the first string in the array
3. Iterate through each element in the array starting at index 1
4. inside the for loop, check for the index of the prefix in the current string elemement
    * if it is not 1, shorten the prefix by 1 char
    * if the prefix if blank, return blank string
5. Outside for and nested while loop, return prefix
    * we are essentially shortening the prefix each iteration of the inner while loop so that is becomes small enough that it now common