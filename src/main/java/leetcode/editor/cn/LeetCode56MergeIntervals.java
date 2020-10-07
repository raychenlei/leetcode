//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组

package leetcode.editor.cn;

import java.util.Arrays;

public class LeetCode56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new LeetCode56MergeIntervals().new Solution();
        solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[][] merge(int[][] intervals) {
        //数组的排序写法，返回的是当前数组，不是新数组
        //使用临时变量来存储最后的结果
        //二维数组的定义
        //二维数组的下标访问
        //数组的拷贝，截取

        //先特判
        if (intervals == null || intervals.length == 0){
            return intervals;
        }
        int[][] merged = new int[intervals.length][];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //要先排序，后赋merged的初值
        merged[0] = intervals[0];
        //记录结果集中实际元素个数
        int mergedNum = 1;
        for (int i = 0; i < intervals.length; i++) {
            //结果集中的最后一个区间和当前区间进行比较，看是否可以合并
            //如果当前区间的左边界大于结果集的右边界，则不可以合并，将当前区间加入结果集
            if (intervals[i][0] > merged[mergedNum - 1][1]){
                mergedNum ++;
                merged[mergedNum - 1] = intervals[i];
            }else {
                //如果当前区间的左边界小于等于结果集的右边界，则可以合并
                //比较结果集的右边界和当前区间的右边界，确定新的结果集的右边界
                if (intervals[i][1] >= merged[mergedNum - 1][1]){
                    merged[mergedNum - 1][1] = intervals[i][1];
                }
            }
        }

        return Arrays.copyOfRange(merged, 0, mergedNum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}