class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < nums[i]) {
                int[] curr = pq.poll();
                ans[curr[1]] = nums[i];
            }

            Stack<Integer> temp = new Stack<>();

            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                temp.push(st.pop());
            }

            while (!temp.isEmpty()) {
                int idx = temp.pop();
                pq.offer(new int[]{nums[idx], idx});
            }

            st.push(i);
        }

        return ans;
        
    }
}