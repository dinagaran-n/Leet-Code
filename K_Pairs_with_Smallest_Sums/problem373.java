class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        List<List<Integer>> result = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        for(int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while(k > 0 && !pq.isEmpty()) {

            int[] current = pq.poll();

            result.add(Arrays.asList(current[0], current[1]));

            if(current[2] + 1 < nums2.length) {

                pq.offer(new int[]{
                    current[0],
                    nums2[current[2] + 1],
                    current[2] + 1
                });
            }

            k--;
        }

        return result;
    }
}
