class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder string = new StringBuilder(a);
        int c = 1;
        while(string.length()<b.length()){
            string.append(a);
            c++;
        }
        if(string.indexOf(b) != -1){
            return c;
        }
        string.append(a);
        c++;
        if(string.indexOf(b) != -1){
            return c;
        }
        return -1;
    }
}
