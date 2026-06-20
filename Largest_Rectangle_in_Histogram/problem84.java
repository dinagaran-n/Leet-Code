class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = heights.length;
        for(int i=0;i<=n;i++){
            int height = (i==n)?0:heights[i];
            while(!stack.isEmpty() && height<heights[stack.peek()]){
                int curHeight = heights[stack.pop()];
                int width;
                if(stack.isEmpty()){
                    width = i;
                }
                else{
                    width = i-stack.peek()-1;
                }
                int area = curHeight*width;
                max = Math.max(max,area);
            }
            stack.push(i);
        }
        return max;
    }
}
