class Solution {
    public int[] dailyTemperatures(int[] t){
        int[] result = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<t.length;i++){
            while(!stack.isEmpty() && t[stack.peek()]<t[i]){
                result[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
