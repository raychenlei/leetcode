
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法

package leetcode.editor.cn;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode面试题40ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new LeetCode面试题40ZuiXiaoDeKgeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) return new int[]{};
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < arr.length; i++) {
                if (queue.size() < k || queue.peek() > arr[i]){
                    queue.offer(arr[i]);
                }
                if (queue.size() > k){
                    queue.poll();
                }
            }
            int[] res = new int[queue.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = queue.poll();
            }
            return res;
        }
    }

    class Solution2 {
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                queue.offer(arr[i]);
            }
            int[] res = new int[k];
            for (int i = 0; i < res.length; i++) {
                res[i] = queue.poll();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}