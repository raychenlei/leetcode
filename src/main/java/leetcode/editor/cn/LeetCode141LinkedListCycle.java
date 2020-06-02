//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针

package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LeetCode141LinkedListCycle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    //两种解法：
    //1、用set记录访问过的节点，如果遇到相同的节点，则说明有环
    //2、快慢指针，快指针移动两步，慢指针移动一步，快慢指针相遇说明有环，当快指针到头时说明无环
    class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null){
                //重点：先移动，再比较
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) return true;
            }
            return false;

        }
    }

    class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            Set<ListNode> set = new HashSet<>();
            while (head != null){
                if (set.contains(head)) return true;
                set.add(head);
                head = head.next;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}