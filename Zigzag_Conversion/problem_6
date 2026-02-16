class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int cycle = numRows*2-2;
        for(int r=0;r<numRows;r++){
            for(int i=r;i<n;i+=cycle){
                result.append(s.charAt(i));
                int diagonal = i+cycle-2*r;
                if(r!=0 && r!=numRows-1 && diagonal<n){
                    result.append(s.charAt(diagonal));
                }
            }
        }
        return result.toString();
    }
}
