class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int bestStart = 0;
        int bestLength = 1;

        for (int center = 0; center < s.length(); center++) {

            int oddLen = stretch(s, center, center);
            int evenLen = stretch(s, center, center + 1);

            int currentBest = Math.max(oddLen, evenLen);

            if (currentBest > bestLength) {
                bestLength = currentBest;
                bestStart = center - (currentBest - 1) / 2;
            }
        }

        return s.substring(bestStart, bestStart + bestLength);
    }

    private int stretch(String text, int left, int right) {

        while (left >= 0 &&
               right < text.length() &&
               text.charAt(left) == text.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}