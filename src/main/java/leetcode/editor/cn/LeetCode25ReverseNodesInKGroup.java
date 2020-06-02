
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;


public class LeetCode25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new LeetCode25ReverseNodesInKGroup().new Solution();
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
    //递归解法
    //几个关键节点：每组的开始、结束节点，每组翻转后返回的节点
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode tail = head;
            for(int i = 0; i < k; i ++){
                if (tail == null){
                    //不满足k个，不翻转
                    return head;
                }
                tail = tail.next;
            }
            ListNode newHead = reverse(head, tail);
            head.next = reverseKGroup(tail, k);
            return newHead;
        }

        /**
         * 翻转链表，左闭右开
         **/
        private ListNode reverse(ListNode head, ListNode tail) {
            ListNode pre = null;
            ListNode cur = head;

            while (cur != tail){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}