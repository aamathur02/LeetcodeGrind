"""
Remove Duplicates
"""
from typing import Counter, List


def remove_duplicates(nums: List[int]) -> int:
    if len(nums): return 0

    i = 0
    for x in range(1, len(nums)):
        if (nums[x] != nums[i]):
            i+=1
            nums[i] = nums[x]

    return i+1

def max_profit(nums:List[int]) -> int:
    profit = 0
    for i in range (1, len(nums)):
        profit +=  max(nums[i] - nums[i -1], 0)

    return profit

def rotate(nums: List[int], k: int):
    k %= len(nums)

    for i in range(0, k):
        nums.insert(0, nums[-1])
        nums.pop(-1)

def contains_duplicate(nums: List[int]) -> bool:
    return True if (len(set(nums)) < len(nums)) else False

def intersection_of_two_arrays(nums1: List[int], nums2: List[int]) -> List[int]:
    counter1 = Counter(nums1)
    counter2 = Counter(nums2)
    return_list = []

    for num in counter1:
        if num in counter2:
            count = 0
            count = min(counter1[num], counter2[num])
        
            for i in range(count):
                return_list.append(num)

    return return_list

def plus_one(nums:List[int]) -> List[int]:
    for i in reversed(range(len(nums))):
        if (nums[i] < 9):
            nums[i] +=1
            return nums
        else:
            nums[i] = 0

    return [1] + [0] * len(nums)

def two_sum(nums: List[int], target: int) -> List[int]:
    for i in range(0, len(nums)):
            complement = target - nums[i]
            print(complement)
            if complement in nums and nums.index(complement) != i:
                print('inside if')
                return [nums.index(complement), i]

def valid_sudoku(board: List[List[str]]) -> bool:
    rows = [{} for i in range (9)]
    columns = [{} for i in range (9)]
    boxes = [{} for i in range (9)]

    for i in range(9):
        for j in range(9):
            num = board[i][j]
            if num != '.':
                n = int(num)
                box_index = (i // 3) * 3  + j // 3;

                rows[i][n] = rows[i].get(n, 0) + 1
                columns[j][n] = columns[j].get(n, 0) + 1
                boxes[box_index][n] = boxes[box_index].get(n, 0) + 1

                if rows[i][n] > 1 or columns[j][n] > 1 or boxes[box_index][n] > 1:
                    return False

    return True

  