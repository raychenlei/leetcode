
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class LeetCode24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new LeetCode24SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }

            ListNode secondNode = head.next;

            head.next = swapPairs(secondNode.next);
            secondNode.next = head;
            return secondNode;
        }
    }

//    class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x){
//            val = x;
//        }
//    }

//leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {
        //非递归解法
        public ListNode swapPairs(ListNode head) {
            ListNode preNode = new ListNode(-1);
            preNode.next = head;

            ListNode temp = preNode;

            while (temp.next != null && temp.next.next != null){

                //两个要交换的节点
                ListNode a = temp.next;
                ListNode b = temp.next.next;

                a.next = b.next;
                b.next = a;
                temp.next = b;
                temp = a;

            }
            return preNode.next;
        }
    }
}