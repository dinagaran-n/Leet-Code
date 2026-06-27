class Solution {
    public boolean isPossible(int[] target) {

        if (target.length == 1)
            return target[0] == 1;

        long sum = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : target) {
            sum += num;
            heap.offer(num);
        }

        while (heap.peek() != 1) {

            int cur = heap.poll();

            if (sum - cur == 1)
                return true;

            int y = (int)(cur % (sum - cur));

            if (y == 0 || y == cur)
                return false;

            sum = sum - cur + y;

            heap.offer(y);
        }

        return true;
    }
}
