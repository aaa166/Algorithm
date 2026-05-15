//Given a string s, find the length of the longest substring without duplicate 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3. Note that "bca" and 
//"cab" are also correct answers.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 45067 👎 2219


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//1
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        int Longest = 0;
//        for (int i = 0; i < s.length(); i++) {
//            Set<Character> set = new HashSet();
//
//            if (s.length()-i <= Longest) break;
//
//            for (int j = i; j < s.length(); j++) {
//                if (set.contains(s.charAt(j))){
//                    Longest = Math.max(Longest,j-i);
//                    break;
//                }else{
//                    set.add(s.charAt(j));
//                    Longest = Math.max(Longest,j-i+1);
//                }
//            }
//        }
//        return Longest;
//    }
//}

//2
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        int Longest = 0;
//        for (int i = 0; i < s.length(); i++) {
//            List<Character> list = new ArrayList<>();
//
//
//            if (s.length()-i <= Longest) break;
//
//            for (int j = i; j < s.length(); j++) {
//                char ch = s.charAt(j);
//
//                if (list.contains(ch)){
//                    Longest = Math.max(Longest,j-i);
//                    int idx = list.indexOf(ch);
//                    i = i + idx;
//                    break;
//                }else{
//                    list.add(ch);
//                    Longest = Math.max(Longest,j-i+1);
//                }
//            }
//        }
//        return Longest;
//    }
//}

//3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int longest = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
