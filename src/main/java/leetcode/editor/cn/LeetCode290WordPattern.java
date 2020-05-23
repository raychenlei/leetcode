//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290WordPattern {
    public static void main(String[] args) {
        Solution solution = new LeetCode290WordPattern().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            //用一个map存储对应关系，key是pattern里的字符，value是str中的单词
            int length = pattern.length();
            String[] words = str.split(" ");
            if (length != words.length) {
                return false;
            }
            Map<Character,String> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                char key = pattern.charAt(i);
                String value = words[i];
                if (map.containsKey(key)){
                    if (!value.equals(map.get(key))){
                        return false;
                    }
                }else {
                    if (map.containsValue(value)){
                        return false;
                    }
                    map.put(key,value);

                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}