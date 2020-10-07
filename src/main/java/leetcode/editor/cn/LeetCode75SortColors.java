//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针

package leetcode.editor.cn;
public class LeetCode75SortColors {
    public static void main(String[] args) {
        Solution solution = new LeetCode75SortColors().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/****
 * 解法1：一次遍历
 * @description
 * @author chenlei
 * @date 2020/10/5 10:05 下午
 * @version 1.0
 **/
class Solution {
    public void sortColors(int[] nums) {
        //荷兰国旗问题，红白蓝
        //一次遍历法，双指针，类似于快排的思想
        //双指针夹逼

        //用left指针表示0区间的右边界，right指针表示2区间的左边界，cur指针表示当前元素
        //cur从0开始循环，直到cur和right相遇
        //若当前元素等于0，交换left和cur指针所指的元素，left++；
        //若当前元素等于2，则交换right和cur指针所指的元素，right--，cur--；
        //这时为什么cur要--，因为right交换过来的元素还没有进行判断，在下次循环中还要判断，而for循环自然的要++，所以这里要--；
        //而每次判断完成之后，数组中left元素（包括）左边的元素和right元素（不包含）右边的元素都已经判断过了，所以等于0时候，cur指针不用变
        //若当前元素等于1，则不交换，cur++；

        int left = 0;
        int right = nums.length - 1;
        for(int cur = 0; cur <= right; cur ++){
            if (nums[cur] == 0){
                int temp = nums[cur];
                nums[cur] = nums[left];
                nums[left] = temp;
                left ++;
            }else if(nums[cur] == 2){
                int temp = nums[cur];
                nums[cur] = nums[right];
                nums[right] = temp;
                right --;
                cur --;
            }
        }

    }
}
    /****
     * 解法2: 两次遍历
     * @description
     * @author chenlei
     * @date 2020/10/5 10:04 下午
     * @version 1.0
     **/
    class Solution2 {
        public void sortColors(int[] nums) {
            //一次循环统计出每个颜色的个数，然后再一次循环对原数组按颜色赋值
            int[] count = new int[3];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0){
                    count[0] ++;
                }else if(nums[i] == 1){
                    count[1] ++;
                }else {
                    count[2] ++;
                }
            }
            for(int i = 0; i < nums.length; i++){
                if (i < count[0]){
                    nums[i] = 0;
                }else if(i < count[0] + count[1]){
                    nums[i] = 1;
                }else {
                    nums[i] = 2;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}