//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找

package leetcode.editor.cn;
public class LeetCode35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new LeetCode35SearchInsertPosition().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int searchInsert(int[] nums, int target) {
            //在排好序的数组中查找特定元素，首选二分法
            //先特判
            int length = nums.length;
            if (length == 0) return -1;
            //定义好左右边界的值，这里的左右边界指的是最终结果的左右边界，所以右边界是length
            int left = 0;
            int right = length;
            while(left < right){
                //先将mid取值为向下取整：mid = left + (right - left) / 2
                //当mid被分到左边区间时（left = mid），mid需要向上取整，也就是 mid = left + (right - left + 1) / 2
                int mid = left + (right - left) / 2;
                //当mid元素小于目标元素时，mid和左边的位置一定不是解，这时查找右边区间
                if (nums[mid] < target){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}