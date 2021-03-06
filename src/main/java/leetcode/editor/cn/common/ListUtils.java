package leetcode.editor.cn.common;

import java.util.List;

/**
 * @author chenlei
 * @version 1.0
 * @description
 * @date 2020/5/22 5:54 PM
 **/
public class ListUtils {
    public static ListNode buildList(int...args){
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        for (int i = 0; i < args.length; i++) {
            ListNode node = new ListNode(args[i]);
            prev.next = node;
            prev = prev.next;
        }
        return preHead.next;
    }

    public static ListNode buildCircleList(List<Integer> list, int index){
        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;

        ListNode circleNode = null;
        ListNode endNode = null;
        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            if (i == index){
                circleNode = node;
            }
            if (i == list.size() - 1){
                endNode = node;
            }
            temp.next = node;
            temp = temp.next;
        }
        endNode.next = circleNode;
        return preHead.next;
    }



    public static void printList(ListNode list){
        if (list == null){
            System.out.println("list is null");
        }
        ListNode prev = list;
        StringBuilder builder = new StringBuilder();
        while (prev != null){
            builder.append(prev.val);
            builder.append("->");
            prev = prev.next;
        }
        builder.append("null");
        System.out.println(builder.toString());
    }
}
