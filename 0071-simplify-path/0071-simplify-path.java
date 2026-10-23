class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] arr = path.split("/");

        for (String s : arr) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(s);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String s : st) {
            ans.append("/").append(s);
        }

        return ans.length() == 0 ? "/" : ans.toString();
        
    }
}