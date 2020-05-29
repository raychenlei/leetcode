
//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
//

package leetcode.editor.cn;

import java.util.*;

public class LeetCode412FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new LeetCode412FizzBuzz().new Solution();
        solution.fizzBuzz(15);
        System.out.println(solution.fizzBuzz(15));
//        for(int i = 0; i < 1; i ++){
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("b", "2");
//            map.put("a", "1");
//            map.put("c", "3");
//            map.put("d", "4");
//
//            for(String key : map.keySet()) {
//                System.out.println(map.get(key));
//            }
//        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)



    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> result = new ArrayList<>();
            for(int i = 1, j = 1, k = 1; i <= n; i++, j++, k++){
                if (j == 3 && k == 5){
                    result.add("FizzBuzz");
                    j = 0;
                    k = 0;
                }else if(j == 3){
                    result.add("Fizz");
                    j = 0;
                }else if(k == 5){
                    result.add("Buzz");
                    k = 0;
                }else {
                    result.add(String.valueOf(i));
                }
            }
            return result;
        }
    }
    class Solution2 {
        public List<String> fizzBuzz(int n) {
            List<String> result = new ArrayList<>();
            for(int i = 1; i <= n; i ++){
                String str = "";
                boolean divideBy3 = i%3 == 0;
                boolean divideBy5 = i%5 == 0;

                if (divideBy3){
                    str += "Fizz";
                }
                if (divideBy5){
                    str += "Buzz";
                }
                if (str.equals("")){
                    str = String.valueOf(i);
                }
                result.add(str);
            }
            return result;
        }
    }

    class Solution3 {
        public List<String> fizzBuzz(int n) {
            //更好的扩展，用map存映射关系，要用LinkedHashMap保证key的顺序，不能用HashMap，因为如果要求返回BuzzFizz，就不行了
            Map<Integer, String> dicMap = new LinkedHashMap<>();
            dicMap.put(5, "Buzz");
            dicMap.put(3, "Fizz");

            List<String> result = new ArrayList<>();
            for(int i = 1; i <= n; i ++){
                String str = "";
                for (Integer key : dicMap.keySet()) {
                    if (i % key == 0){
                        str += dicMap.get(key);
                    }
                }
                if (str.equals("")){
                    str = String.valueOf(i);
                }
                result.add(str);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)




}