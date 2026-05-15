//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics Two Pointers String Dynamic Programming 👍 32694 👎 2015


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int longest = 1;
        String result = s.substring(0,1);


        for (int i = 0; i < s.length()-1; i++) {

            int one = 1;
            while (i - one >= 0
                    && i + one < s.length()
                    && s.charAt(i - one) == s.charAt(i + one)) {
                one++;
            }
            int len1 = (one - 1) * 2 + 1;
            if (len1 > longest) {
                longest = len1;
                result = s.substring(i - (one - 1), i + (one - 1) + 1);
            }


            int two = 0;
            while (i - two >= 0
                    && i + 1 + two < s.length()
                    && s.charAt(i - two) == s.charAt(i + 1 + two)) {
                two++;
            }
            int len2 = two * 2;
            if (len2 > longest) {
                longest = len2;
                result = s.substring(i - (two - 1), i + two + 1);
            }

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
