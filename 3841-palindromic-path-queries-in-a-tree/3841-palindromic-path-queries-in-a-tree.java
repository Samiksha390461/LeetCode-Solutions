class Solution {
    private List<Integer>[] graph;
    private int[][] up;
    private int[] depth, tin, tout;
    private int timer, log;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        log = 1;
        while ((1 << log) <= n) {
            log++;
        }

        up = new int[log][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];

        buildTree(n);

        BIT bit = new BIT(2 * n + 2);
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            bit.update(tin[i], mask);
            bit.update(tout[i], mask);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split("\\s+");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');
                int diff = oldMask ^ newMask;

                if (diff != 0) {
                    bit.update(tin[u], diff);
                    bit.update(tout[u], diff);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (chars[ancestor] - 'a'));

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private void buildTree(int n) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int[] stackNode = new int[2 * n + 2];
        int[] stackState = new int[2 * n + 2];
        int top = 0;

        stackNode[top] = 0;
        stackState[top++] = 0;
        parent[0] = 0;

        timer = 0;

        while (top > 0) {
            int node = stackNode[--top];
            int state = stackState[top];

            if (state == 1) {
                tout[node] = timer++;
                continue;
            }

            tin[node] = timer++;

            stackNode[top] = node;
            stackState[top++] = 1;

            for (int i = graph[node].size() - 1; i >= 0; i--) {
                int child = graph[node].get(i);

                if (child == parent[node]) {
                    continue;
                }

                parent[child] = node;
                depth[child] = depth[node] + 1;

                stackNode[top] = child;
                stackState[top++] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            up[0][i] = parent[i];
        }

        for (int j = 1; j < log; j++) {
            for (int i = 0; i < n; i++) {
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }
    }

    private int lca(int u, int v) {
        if (isAncestor(u, v)) {
            return u;
        }

        if (isAncestor(v, u)) {
            return v;
        }

        for (int j = log - 1; j >= 0; j--) {
            if (!isAncestor(up[j][u], v)) {
                u = up[j][u];
            }
        }

        return up[0][u];
    }

    private boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }

    static class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index, int value) {
            for (int i = index + 1; i <= n; i += i & -i) {
                tree[i] ^= value;
            }
        }

        int query(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
        
    }
}