

from typing import List


def linearSearch(array: List[int], target: int) -> int:
    return array.index(target)

def main():
    print(linearSearch([1,2,3], 3))

if __name__ == "__main__":
    main()