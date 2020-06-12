
//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import leetcode.editor.cn.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode429NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new LeetCode429NAryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution2 {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < size; i ++){
                    Node node = queue.poll();
                    list.add(node.val);
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
                res.add(list);
            }
            return res;
        }

    }
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            traversal(0, root, res);
            return res;
        }
        private void traversal(int level, Node root, List<List<Integer>> res) {
            if (root == null) return;
            if (res.size() <= level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            for (Node child : root.children) {
                traversal(level + 1, root, res);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}