
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.editor.cn;
public class LeetCode88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new LeetCode88MergeSortedArray().new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1, 3, nums2, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        //从后往前填充nums1
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while (i >= 0 && j >= 0)
                nums1[k --] = nums1[i] > nums2[j] ? nums1[i --] : nums2[j --];
            if(j >= 0)
                System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }


    class Solution2 {
        //使用额外的空间
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int [] nums3 = new int[m + n];
            int k = 0;
            int i = 0;
            int j = 0;
            while(i < m && j < n){
                nums3[k ++] = nums1[i] < nums2[j] ? nums1[i ++] : nums2[j ++];
            }
            if (i == m){
                System.arraycopy(nums2, j, nums3, k, n - j);
            }else {
                System.arraycopy(nums1, i, nums3, k, m - i);
            }
            System.arraycopy(nums3, 0, nums1, 0, m + n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}