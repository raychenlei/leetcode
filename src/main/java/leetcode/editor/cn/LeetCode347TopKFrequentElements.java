
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表

package leetcode.editor.cn;

import java.util.*;

public class LeetCode347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new LeetCode347TopKFrequentElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (queue.size() < k){
                    queue.offer(entry);
                }else {
//                    if (entry.getValue(1) > queue.size()){
//
//                    }
                }
            }
            int[] res = new int[k];
            for (int i = 0; i < res.length; i++) {
                res[i] = queue.poll().getKey();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}