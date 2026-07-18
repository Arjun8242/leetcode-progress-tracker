class Solution:
    def findGCD(self, nums: List[int]) -> int:
        nums.sort()
        smallest=min(nums)
        largest=max(nums)

        while smallest!=0:
            largest, smallest = smallest, largest % smallest

        return largest