from typing import List


def iterative_binary_search(array: List[int], target: int) -> int:
    first  = 0;
    last = len(array) - 1;
    mid = 0;

    while (first <= last):
        mid = first + (last - first) // 2
       
        if (array[mid] == target):
            return mid
            
        if (array[mid] > target):
            last = mid - 1

        else:
            first = mid + 1

    return -1 

def recursive_binary_search(array: List[int], target: int, low: int, high: int) -> int:
    if (low <= high):
        mid = low + (high - low) // 2

        if (array[mid] == target):
            return mid
        
        if (array[mid] > target):
            return recursive_binary_search(array, target, low, mid - 1)

        else:
            return recursive_binary_search(array, target, mid + 1, high)

    
    return -1

def main():
    list = [1,2,3,4,5,6,7,8,9]

    print(iterative_binary_search(list, 8))
    print(recursive_binary_search(list, 8, 0, (len(list) - 1)))

if __name__ == "__main__":
    main()