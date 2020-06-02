//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针

package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;
import leetcode.editor.cn.common.ListUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode142LinkedListCycleIi {
    public static void main(String[] args) {
        ListNode node = ListUtils.buildList(3, 2, 0, -4);
        ListNode head = ListUtils.buildCircleList(Arrays.asList(3, 2, 0, -4), 1);
        Solution solution = new LeetCode142LinkedListCycleIi().new Solution();
        ListNode node1 = solution.detectCycle(head);
        System.out.println("Node");
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
    //两种解法
    //1、顺序遍历整个链表，用一个set记录途径的节点，如果发现了第一个重复的节点，则该节点就是环的入口
    //2、Floyd法：快慢指针
    //  1)第一步，找到快慢指针相遇点（快慢指针都从head开始），如果没有相遇，则没有环
    //  2)第二步，双指针移动，头指针位于head，尾指针位于相遇点，每次都向前移动一位，再次相遇时就是环的入口
    class Solution {
        public ListNode detectCycle(ListNode head) {
            //Floyd法
            //1、找出相遇点
            if (head == null || head.next == null) return null;
            ListNode slow = head;
            ListNode fast = head;
            ListNode meet = null;
            while (fast != null && fast.next != null){
                //没有环的时候退出，只需要判断快指针是否为空就可以了
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    meet = slow;
                    break;
                }
            }
            if (meet == null) return null;

            //2、夹逼找到入口
            ListNode p1 = head;
            ListNode p2 = meet;
            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }

    }


    class Solution2 {
        //遍历法
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;

            Set<ListNode> set = new HashSet<>();
            ListNode cur = head;
            while (cur != null){
                if (set.contains(cur)) return cur;
                set.add(cur);
                cur = cur.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}