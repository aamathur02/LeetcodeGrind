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