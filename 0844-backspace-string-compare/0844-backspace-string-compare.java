class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));

        
    }
    public String build(String s) {
        StringBuilder st = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (st.length() > 0) {
                    st.deleteCharAt(st.length() - 1);
                }
            } else {
                st.append(ch);
            }
        }

        return st.toString();
    }
}