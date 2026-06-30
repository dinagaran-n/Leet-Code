class Solution {
    public String maskPII(String S) {
        String[] ctry = {"","+*-","+**-","+***-"};
        int at = S.indexOf("@");
        if(at>0){
            S = S.toLowerCase();
            return (S.charAt(0)+"*****"+S.substring(at-1).toLowerCase());
        }
        S = S.replaceAll("[^0-9]","");
        return ctry[S.length()-10]+"***-***-"+S.substring(S.length()-4);
    }
}
