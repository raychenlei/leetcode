package leetcode.editor.cn;

/**
 * @author chenlei
 * @version 1.0
 * @description
 * @date 2020/6/8 3:45 PM
 **/
public class Solution {
    public int getKthMagicNumber(int k) {
        int p3 = 0, p5 = 0, p7 = 0;
        int[] res = new int[k];
        res[0] = 1;
        for(int i = 1; i < k; i ++){
            res[i] = Math.min(res[p3] * 3, Math.min(res[p5] * 5, res[p7] * 7));
            if(res[i] == res[p3] * 3) p3 ++;
            if(res[i] == res[p5] * 5) p5 ++;
            if(res[i] == res[p7] * 7) p7 ++;
        }
        return res[k - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getKthMagicNumber(9);
    }
}
