
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.Arrays;

public class LeetCode66PlusOne {
    public static void main(String[] args) {
        Solution solution = new LeetCode66PlusOne().new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9})));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] plusOne(int[] digits) {
        //这道题的关键是不知道进位的情况发生在哪个位置，也就不能判断最终的数组一共有几位
        //每位上只需要特殊判断是否是9，如果是9就进位，继续循环，否则就加一跳出循环，返回当前数组
        //当退出循环时，看看当前指针是不是-1，如果是，则说明原数组全部是9
        //这时就创建长度为length + 1的数组，第一位赋值1，返回。（其余各位都是0，初始值就可以）
        int i = digits.length - 1;
        while (i >= 0){
            if (digits[i] == 9){
                digits[i] = 0;
                i --;
            }else {
                digits[i] ++;
                break;
            }
        }
        if (i >= 0){
            return digits;
        }else {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}