class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        ArrayList<Integer>[] adj = new ArrayList[n];
        ArrayList<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] newParent = parent.clone();
        int[] prev = new int[n];

        Stack<Integer> st = new Stack<>();
        Stack<Integer> state = new Stack<>();

        st.push(0);
        state.push(0);

        while (!st.isEmpty()) {
            int u = st.pop();
            int type = state.pop();

            int c = s.charAt(u) - 'a';

            if (type == 0) {
                prev[u] = last[c];

                if (last[c] != -1) {
                    newParent[u] = last[c];
                }

                last[c] = u;

                st.push(u);
                state.push(1);

                for (int v : adj[u]) {
                    st.push(v);
                    state.push(0);
                }
            } else {
                last[c] = prev[u];
            }
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        ArrayList<Integer> order = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            order.add(u);

            for (int v : tree[u]) {
                stack.push(v);
            }
        }

        for (int i = order.size() - 1; i >= 0; i--) {
            int u = order.get(i);

            if (u != 0) {
                ans[newParent[u]] += ans[u];
            }
        }

        return ans;
        
    }
}