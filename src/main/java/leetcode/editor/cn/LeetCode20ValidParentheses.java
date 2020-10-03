//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LeetCode20ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    //使用栈，不匹配就入栈，匹配就出栈，最后如果栈不为空，则返回false
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> dicMap = new HashMap<>();
            dicMap.put('(', ')');
            dicMap.put('[', ']');
            dicMap.put('{', '}');

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);
                if (c == ' ') continue;
                if (dicMap.containsKey(c)){
                    stack.push(c);
                    continue;
                }
                if (dicMap.containsValue(c)){
                    if(stack.isEmpty()) return false;
                    Character peek = stack.peek();
                    if (c != dicMap.get(peek)) return false;
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}