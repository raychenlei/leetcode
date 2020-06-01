//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

import java.util.List;

public class LeetCode206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new LeetCode206ReverseLinkedList().new Solution();
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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //只换指针，不交换节点，原地反转
            ListNode pre = null;
            ListNode current = head;
            while (current != null){
                ListNode temp = current.next;
                current.next = pre;
                pre = current;
                current = temp;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}