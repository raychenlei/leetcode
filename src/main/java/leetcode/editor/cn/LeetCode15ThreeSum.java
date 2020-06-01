//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15ThreeSum {

    public static void main(String[] args) {
        Solution solution = new LeetCode15ThreeSum().new Solution();
    }

    //暴力法，嵌套循环

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 3){
                return res;
            }
            for(int k = 0; k < nums.length -2; k ++){
                if (nums[k] > 0) break;
                int target = -nums[k];
                int i = k + 1;
                int j = nums.length - 1;
                if (k > 0 && nums[k] == nums[k-1]) continue;
                while (i < j){
                    if (nums[i] + nums[j] == target){
                        res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[++i]);
                        while (i < j && nums[j] == nums[--j]);
                    }else if(nums[i] + nums[j] < target){
                        while (i < j && nums[i] == nums[++i]);
                    }else {
                        while (i < j && nums[j] == nums[--j]);
                    }
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}