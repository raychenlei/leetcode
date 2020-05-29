//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针

package leetcode.editor.cn;
public class LeetCode11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new LeetCode11ContainerWithMostWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maxArea(int[] height) {
            //双指针法,每次移动较矮的那个柱子
            int i = 0;
            int j = height.length - 1;
            int maxArea = 0;
            while (i < j){
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
                if(height[i] <= height[j]){
                    i ++;
                }else {
                    j --;
                }
            }
            return maxArea;
        }
    }

    class Solution2 {
        public int maxArea(int[] height) {
            //暴力解法，双层循环，O(n2)
            // max[(j-i) * (min(height[i-1],height[j-1]))]
            int maxArea = 0;
            int temp = 0;
            int length = height.length;
            for (int i = 1; i < length; i++) {
                for (int j = i+1; j<= length; j++) {
                    temp = (j -i) * Math.min(height[i-1], height[j-1]);
                    maxArea = Math.max(maxArea, temp);
                }
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}