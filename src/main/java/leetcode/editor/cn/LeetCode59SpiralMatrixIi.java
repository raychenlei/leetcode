
//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组

package leetcode.editor.cn;
public class LeetCode59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new LeetCode59SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //找固定点，一层一层的循环。
        //固定左上角的点(startX,startY)和右下角的点(endX,endY)，一条边一条边的填充，每填完一条边，startX，startY，endX，endY的值就要对应的加减
        public int[][] generateMatrix(int n) {
            if (n == 0) {
                return null;
            }
            int[][] nums = new int[n][n];
            int startX = 0;
            int startY = 0;
            int endX = n - 1;
            int endY = n - 1;
            int num = 1;
            int target = n * n;
            while(num <= target){
                for (int j = startY; j <= endY; j++){
                    nums[startX][j] = num ++;
                }
                startX ++;
                for (int i = startX; i <= endX; i ++){
                    nums[i][endY] = num ++;
                }
                endY --;
                for (int j = endY; j >= startY; j --){
                    nums[endX][j] = num ++;
                }
                endX --;
                for (int i = endX; i >= startX; i --){
                    nums[i][startY] = num ++;
                }
                startY ++;
            }
            return nums;



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}