//给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。 
//
// 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。 
//
// 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。 
//
// 
//
// 示例 1： 
//
// 输入：
//nums = [1, 7, 3, 6, 5, 6]
//输出：3
//解释：
//索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
//同时, 3 也是第一个符合要求的中心索引。
// 
//
// 示例 2： 
//
// 输入：
//nums = [1, 2, 3]
//输出：-1
//解释：
//数组中不存在满足此条件的中心索引。 
//
// 
//
// 说明： 
//
// 
// nums 的长度范围为 [0, 10000]。 
// 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。 
// 
// Related Topics 数组

package leetcode.editor.cn;
public class LeetCode724FindPivotIndex {
    public static void main(String[] args) {
        Solution solution = new LeetCode724FindPivotIndex().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int pivotIndex(int[] nums) {
        //这道题的关键是要理解中心索引的特点：也就是 数组元素总和 = 中心索引左边元素总和 * 2 + 中心索引元素，该问题称之为前缀和问题
        //先一次循环，计算出元素总和，然后再一次循环，从索引0开始遍历判断是否是中心索引，同时记录下左边元素的总和
        //要注意特判，数组为空的情况

        if (nums.length == 0) return -1;
        int leftSum = 0;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for(int i = 0; i < nums.length; i ++){
            if(leftSum * 2 + nums[i] == totalSum) return i;
            leftSum += nums[i];
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}