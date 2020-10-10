
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
//
// 
//
// 示例 1: 
//
// 给定 nums = [3,2,2,3], val = 3,
//
//函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2: 
//
// 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
//
//函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
//
//注意这五个元素可为任意顺序。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 675 👎 0

package leetcode.editor.cn;
public class LeetCode27RemoveElement {
    public static void main(String[] args) {
        Solution solution = new LeetCode27RemoveElement().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/**
 * 双指针的题目
 * 重点：
 * 1、和删除排序数组中的重复元素很像
 * 2、双指针，快慢指针，慢指针的值也是最终数组的大小
 * 3、适合需要删除的元素较多的情况比如[4,4,4,4,5] val=4，就只需要替换1次，最差的情况，i和j都需要遍历n步
 *
 * @description
 * @author chenlei
 * @date 2020/10/10 7:34 PM
 * @version 1.0
 **/
class Solution {
    public int removeElement(int[] nums, int val) {
        //设置两个指针i和j，慢指针i初始值是0，快指针j初始值也是0
        //快指针从0到n-1开始遍历，当遇到和指定值相同元素就跳过：j++
        //当和指定元素不同时，将nums[i]=nums[j],然后i和j都往前进一步
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for(int j = 0; j < nums.length; j ++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }
}

/****
 * 优化解法-双指针，夹逼法
 * 适合需要替换的元素比较少的情况，比如nums=[1，2，3，5，4]，Val=4，算法1就需要替换4次
 * @description
 * @author chenlei
 * @date 2020/10/10 7:47 PM
 * @version 1.0
 **/
class Solution2 {
    public int removeElement(int[] nums, int val) {
        //首尾双指针，往中间夹逼
        //当nums[head] != val时，head++
        //当nums[head] == val时，把tail元素替换过来：nums[head] = nums[tail], 相当于舍去了原来的head元素
        // 然后tail递进tail--，相当于把数组长度减1，原来的tail元素位于head处，在下一次循环中会进行判断
        //直到head和tail相遇
        if (nums == null || nums.length == 0) return 0;
        int head = 0;
        int tail = nums.length;
        while(head < tail){
            if(nums[head] == val){
                nums[head] = nums[tail - 1];
                tail --;
            }else {
                head ++;
            }
        }
        return head;
    }
}




//leetcode submit region end(Prohibit modification and deletion)

}