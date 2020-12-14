"""
Remove Duplicates
"""



from typing import List


def removeDuplicates(nums: List[int]) -> int:
    if len(nums): return 0

    i = 0
    for x in range(1, len(x)):
        if (nums[x] != nums[i]):
            i+=1
            nums[i] = nums[j]

    return i+1

def maxProfit(nums:List[int]) -> int:
    profit = 0
    for i in range (1, len(nums)):
        profit +=  max(nums[i] - nums[i -1], 0)

    return profit

def rotate(nums: List[int], k: int):
    k %= len(nums)

    for i in range(0, k):
        nums.insert(0, nums[-1])
        nums.pop(-1)

