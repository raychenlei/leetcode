
//有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"
//，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
//
// 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。 
//
// 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。 
//
// 
//
// 示例 1： 
//
// 输入："(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 输入："(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 输入："()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 10000 
// S[i] 为 "(" 或 ")" 
// S 是一个有效括号字符串 
// 
// Related Topics 栈

package leetcode.editor.cn;

import java.util.Stack;

public class LeetCode1021RemoveOutermostParentheses {
    public static void main(String[] args) {
        Solution solution = new LeetCode1021RemoveOutermostParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeOuterParentheses(String S) {
            //使用计数器来模拟进栈和出栈
            //左括号加一，如果计数器为0，则记录起始位置，右括号减一，如果计数器为0，则输出，起始位置清零
            return null;

        }
    }

    class Solution2 {
        public String removeOuterParentheses(String S) {
            //用栈来处理
            //遇到左括号进栈，如果是第一次进栈，记录一下下标，表示一个原语的开始
            //遇到右括号出栈，如果出栈后栈为空，则表示一个原语的结束，输出这个原语（掐头去尾），下标记录清零

            StringBuilder sb = new StringBuilder();
            int start = 0;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < S.length(); i ++){
                char c = S.charAt(i);
                if(c == '('){
                    if (stack.isEmpty()){
                        start = i;
                    }
                    stack.push(c);
                }else {
                    stack.pop();
                    if (stack.isEmpty()){
                        sb.append(S.substring(start + 1, i));
                        start = 0;
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}