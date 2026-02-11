class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxlen = Math.min(s.length(),1);
        while(end<s.length()){
            char c = s.charAt(end);
            while(seen.contains(c)){
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(s.charAt(end));
            int windowSize = end-start+1;
            maxlen = Math.max(maxlen,windowSize);
            end++;
        }
        return maxlen;
    }
}
