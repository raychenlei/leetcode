
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
//

package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

import java.util.Stack;

public class LeetCodeInterview06CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new LeetCodeInterview06CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
        public int[] reversePrint(ListNode head) {
            //两次循环，先翻转链表，再循环遍历，难点是不知道链表的长度
            int size = 0;
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                size ++;
            }
            ListNode newHead = pre;
            int[] res = new int[size];
            for (int i = 0; i < size; i ++){
                res[i] = newHead.val;
                newHead = newHead.next;
            }
            return res;
        }

        public int[] reversePrint2(ListNode head) {
            //使用栈，两次遍历，第一次遍历进栈，第二次遍历出栈，输出
            Stack<ListNode> stack = new Stack<>();
            int size = 0;
            while (head != null){
                stack.push(head);
                head = head.next;
                size ++;
            }
            int[] res = new int[size];
            for(int i = 0; i < size; i ++){
                res[i] = stack.pop().val;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}