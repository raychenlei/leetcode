//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//

package leetcode.editor.cn;
public class LeetCodeInterview05TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new LeetCodeInterview05TiHuanKongGeLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);
                String temp = c == ' ' ? "%20" : String.valueOf(c);
                sb.append(temp);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}