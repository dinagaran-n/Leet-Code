class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {

        Arrays.sort(nums);

        int smallestGap = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            smallestGap = Math.min(smallestGap, nums[i] - nums[i - 1]);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == smallestGap) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[i - 1]);
                pair.add(nums[i]);
                answer.add(pair);
            }
        }

        return answer;
    }
}
