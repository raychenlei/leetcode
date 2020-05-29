
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学

package leetcode.editor.cn;
public class LeetCode258AddDigits {
    public static void main(String[] args) {
        Solution solution = new LeetCode258AddDigits().new Solution();
        System.out.println(solution.addDigits(38));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution2 {
        public int addDigits(int num) {
            if (num < 10) return num;

            String s = String.valueOf(num);
            int res = 0;
            for(int i = 0; i < s.length(); i ++){
                res += Integer.parseInt(s.substring(i, i + 1));
            }
            return addDigits(res);
        }
    }
    class Solution3 {
        public int addDigits(int num) {
            if (num < 10) return num;
            int res = 0;
            while (num != 0){
                res += num % 10;
                num /= 10;
            }
            return addDigits(res);
        }
    }

    class Solution {
        public int addDigits(int num) {
            while (num >= 10){
                int res = 0;
                while (num != 0){
                    res += num % 10;
                    num /= 10;
                }
                num = res;
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}