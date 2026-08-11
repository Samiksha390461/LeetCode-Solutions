class Solution {
    public int lengthOfLastWord(String s) {
        int n= s.length();
        int c=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if(c>0) break;
            }
            else c++;
        }
        return c;
        
    }
}