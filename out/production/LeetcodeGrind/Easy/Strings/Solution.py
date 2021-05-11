import collections

def reverse_string(s: List[str]) -> None:
    s = s.reverse()

def reverse_integet(x: int) -> int:
    result = 0
        
    while (x != 0):
        pop = x % 10
        x = x // 10
        
        result = result * 10 + pop
        
    return result

def first_unique_char(s: str) -> int:
    count = collections.Counter(s)

    for id, char in enumerate(s):
        if count[char] == 1:
            return id
    
    return -1

def is_anagram(s: str, l: str) -> bool:
    return collections.Counter(s) == collections.Counter(l)

def is_palindrome(s: str) -> bool:
    pass

def strstr(haystack: str, needle: str) -> int:
    if (needle == ""): return 0

    if needle in haystack:
        return haystack.find(needle)
    else:
        return -1