package train.week1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenlei
 * @version 1.0
 * @description
 * @date 2020/5/24 2:48 下午
 **/
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
