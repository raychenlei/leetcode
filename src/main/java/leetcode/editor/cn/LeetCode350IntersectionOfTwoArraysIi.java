
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找

package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode350IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new LeetCode350IntersectionOfTwoArraysIi().new Solution();
        int[] nums1 = new int[]{1,2,3};
//        int i = 0;
//        System.out.println(nums1[++i]);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums1,0,1+1)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            //保证nums1长度较短
            if (nums1.length > nums2.length){
                return intersect(nums2, nums1);
            }
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }
            int k = 0;
            for (int i = 0; i < nums2.length; i++) {
                Integer times = map.getOrDefault(nums2[i], 0);
                if (times > 0){
                    nums1[k] = nums2[i];
                    map.put(nums2[i], times - 1);
                    k ++;
                }
            }
            return Arrays.copyOfRange(nums1, 0, k);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < nums1.length && j < nums2.length){
                if (nums1[i] == nums2[j]){
                    nums1[k] = nums1[i];
                    i++;
                    j++;
                    k++;
                }else if(nums1[i] < nums2[j]){
                    i++;
                }else if(nums1[i] > nums2[j]){
                    j++;
                }
            }
            return Arrays.copyOfRange(nums1, 0, k);
        }
    }

}