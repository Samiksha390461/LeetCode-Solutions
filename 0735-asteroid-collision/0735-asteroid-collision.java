class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && !st.isEmpty() &&
                   st.peek() > 0 && asteroid < 0) {

                int top = st.peek();

                if (top < -asteroid) {
                    st.pop();
                }
                else if (top == -asteroid) {
                    st.pop();
                    alive = false;
                }
                else {
                    alive = false;
                }
            }

            if (alive) {
                st.push(asteroid);
            }
        }

        int[] result = new int[st.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
        
    }
}