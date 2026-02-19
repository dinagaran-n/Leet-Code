class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int cur = 1;
        int result = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cur+=1;
            }
            else{
                result+= Math.min(prev,cur);
                prev=cur;
                cur=1;
            }
        }
        result+= Math.min(prev,cur);
        return result;
    }
}
