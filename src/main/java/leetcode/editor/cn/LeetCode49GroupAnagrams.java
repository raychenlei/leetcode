
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

package leetcode.editor.cn;

import java.util.*;

public class LeetCode49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new LeetCode49GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"",""});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //把每个字符串排序
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if (!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(strs[i]);
            }
            List<List<String>> res = new ArrayList<>();
            for (List<String> list : map.values()) {
                res.add(list);
            }
            return res;
        }

    }

    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                checkAnagram(str, map);
            }
            List<List<String>> res = new ArrayList<>();
            for (List<String> list : map.values()) {
                res.add(list);
            }
            return res;
        }

        private void checkAnagram(String str, Map<String, List<String>> map) {
            if (map.containsKey(str)){
                map.get(str).add(str);
                return;
            }
            for (String key : map.keySet()) {
                if(isAnagram(key, str)){
                    map.get(key).add(str);
                    return;
                }
            }
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(str, list);
        }

        private boolean isAnagram(String key, String str) {
            if (key.length() != str.length()) return false;
            if (key.isEmpty()) return true;

            char[] chars1 = key.toCharArray();
            char[] chars2 = str.toCharArray();

            //判断各个字符出现次数是否相等
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < chars1.length; i++) {
                map.put(chars1[i], map.getOrDefault(chars1[i], 0) + 1);
                map.put(chars2[i], map.getOrDefault(chars2[i], 0) - 1);
            }
            for (Integer count : map.values()) {
                if (count != 0) return false;
            }
            return true;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}