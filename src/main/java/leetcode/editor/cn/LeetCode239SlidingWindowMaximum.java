
//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class LeetCode239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new LeetCode239SlidingWindowMaximum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            //使用双端队列，实现一个单调递减队列
            Deque<Integer> deque = new ArrayDeque<>();
            //标记结果数组的下标
            int index = 0;
            for(int i = 0; i < nums.length; i ++){
                //当窗口形成之后，每次移动都需要判断，舍去的节点(下标是i-k)在不在队首，如果在则要从队首删除
                if(i > k - 1){
                    if (deque.peek() == nums[i - k]) deque.removeFirst();
                }
                //入队操作，舍去队列中比当前小的节点，因为这些点永远也不可能成为窗口中的最大值，你品，你细品
                while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                    deque.removeLast();
                }
                deque.add(nums[i]);
                //当窗口形成之后，记录
                if(i >= k - 1){
                    res[index ++] = deque.peekFirst();
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            //用PriorityQueue实现大顶堆，PriorityQueue默认是小顶堆
            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
            int index = 0;
            for(int i = 0; i < nums.length; i ++){
                //前k次遍历，初始化堆
                if (i < k){
                    heap.offer(nums[i]);
                    if (heap.size() == k) res[index ++] = heap.peek();
                    continue;
                }
                //remove
                heap.remove(nums[i - k]);
                //add
                heap.offer(nums[i]);
                //peek
                res[index ++] = heap.peek();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}