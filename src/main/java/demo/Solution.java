package demo;

import java.util.Arrays;

/**
 * @author chenlei
 * @version 1.0
 * @description
 * @date 2020/10/9 12:45 PM
 **/
public class Solution {
    public int pivotIndex(int[] nums) {
        return 1;

    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] merged = new int[intervals.length][];
        int mergedIndex = 0;
        merged[0] = intervals[0];
        for(int i = 0; i < intervals.length; i ++){
            if (intervals[i][0] > merged[mergedIndex][1]){
                merged[++mergedIndex] = intervals[i];
            }else {
                merged[mergedIndex][1] = Math.max(intervals[i][1], merged[mergedIndex][1]);
            }
        }
        return Arrays.copyOfRange(merged, 0, mergedIndex + 1);
    }
}
