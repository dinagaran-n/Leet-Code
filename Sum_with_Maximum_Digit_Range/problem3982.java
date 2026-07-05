class Solution {
    public int maxDigitRange(int[] nums) {
        int max = -1, sum = 0;

        for (int n : nums) {
            int x = n, mn = 9, mx = 0;

            if (x == 0) mn = 0;

            while (x > 0) {
                int d = x % 10;
                mn = Math.min(mn, d);
                mx = Math.max(mx, d);
                x /= 10;
            }

            int range = mx - mn;

            if (range > max) {
                max = range;
                sum = n;
            } else if (range == max) {
                sum += n;
            }
        }

        return sum;
    }
}
