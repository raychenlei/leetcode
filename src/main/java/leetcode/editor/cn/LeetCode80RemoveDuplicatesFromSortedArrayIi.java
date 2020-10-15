
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定 nums = [1,1,1,2,2,3],
//
//函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,1,2,3,3],
//
//函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
// Related Topics 数组 双指针 
// 👍 294 👎 0

package leetcode.editor.cn;
public class LeetCode80RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new LeetCode80RemoveDuplicatesFromSortedArrayIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/****
 * 双指针类型的题目
 * 重点：
 * 1、固定一个指针index，用于标记结果数组的位置，另一个指针用于遍历，最终结果为[0,index]的区间数据，数组长度为index + 1
 * 2、用一个变量用于记录每个元素重复的次数，
 *      当遇到一个新的元素，将count变成1，index ++,将index的元素替换为nums[i]
 *      遇到相同的元素，count++,如果count<=2, index ++,将index的元素替换为nums[i]
 * 3、可以扩展到重复元素最多出现k次
 * @description
 * @author chenlei
 * @date 2020/10/15 3:08 PM
 * @version 1.0
 **/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;
        int count = 1;
        int index = 0;
        for(int i = 1; i < nums.length; i ++){
            if (nums[i] == nums[i - 1]){
                count ++;
                if (count <= 2){
                    index ++;
                    nums[index] = nums[i];
                }
            }else {
                count = 1;
                index ++;
                nums[index] = nums[i];

            }
        }
        return index + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}