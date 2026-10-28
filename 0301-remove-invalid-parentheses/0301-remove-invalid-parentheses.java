class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (isValid(str)) {
                result.add(str);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c != '(' && c != ')') continue;

                if (i > 0 && str.charAt(i) == str.charAt(i - 1))
                    continue;

                String next = str.substring(0, i) + str.substring(i + 1);

                if (visited.add(next)) {
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }
}