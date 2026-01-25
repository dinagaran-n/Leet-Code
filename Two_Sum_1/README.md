## Two Sum

Problem:
Given an array of integers and a target value, find two indices such that their sum is equal to the target.

Approach:
Loop through the array and store each number with its index in a HashMap.
For every number, check if the required complement is already in the map.
If found, return both indices.

Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Complexity:
Time: O(n)
Space: O(n)

Language: Java
