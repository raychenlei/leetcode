//你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对
//了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。 
//
// 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。 
//
// 请注意秘密数字和朋友的猜测数都可能含有重复数字。 
//
// 示例 1: 
//
// 输入: secret = "1807", guess = "7810"
//
//输出: "1A3B"
//
//解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。 
//
// 示例 2: 
//
// 输入: secret = "1123", guess = "0111"
//
//输出: "1A1B"
//
//解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。 
//
// 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。 
// Related Topics 哈希表

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode299BullsAndCows {
    public static void main(String[] args) {
        Solution solution = new LeetCode299BullsAndCows().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getHint(String secret, String guess) {
            //1、统计位置相同数字也相同的个数A
            //2、统计数字相同的个数C（包括位置也相同），B=C-A
            //用两个Map来统计secret和guess中各自相同数字的个数，两者取较小的就是C
            if (secret == null || guess == null || secret.length() != guess.length()){
                throw new IllegalArgumentException("wrong param");
            }
            int length = secret.length();
            int countA = 0;
            int countB;
            int countC = 0;
            Map<Character,Integer> mapS = new HashMap<>();
            Map<Character,Integer> mapG = new HashMap<>();

            for (int i = 0; i < length; i++) {
                char secretChar = secret.charAt(i);
                char guessChar = guess.charAt(i);
                if (secretChar == guessChar){
                    countA ++;
                }
                mapS.put(secretChar, mapS.getOrDefault(secretChar,0) + 1);
                mapG.put(guessChar, mapG.getOrDefault(guessChar,0) + 1);
            }
            for (Character key : mapG.keySet()) {
                int min = Math.min(mapG.get(key), mapS.getOrDefault(key, 0));
                countC = countC + min;
            }
            countB = countC - countA;
            return countA + "A" + countB + "B";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class WrongSolution {
        /*
		 * 没有理解题目意思，重复的数字是要以secret的重复次数为准，
		 * 测试用例:"1122"
		 * "2211"
		 * 测试结果:"0A4B"
		 * 期望结果:"0A4B"
         **/
        public String getHint(String secret, String guess) {
            //用一个set存放secret的数字，用来判断奶牛，遍历secret用来判断公牛
            //用另一个set来存放相同的奶牛
            if (secret == null || guess == null || secret.length() != guess.length()){
                throw new IllegalArgumentException("wrong param");
            }
            int length = secret.length();
            HashSet<Character> secretChars = new HashSet<>();
            HashSet<Character> guessBChars = new HashSet<>();

            int countA = 0;
            for (int i = 0; i <length; i++) {
                char secretChar = secret.charAt(i);
                secretChars.add(secretChar);
            }
            for (int i = 0; i < length; i++) {
                char secretChar = secret.charAt(i);
                char guessChar = guess.charAt(i);
                if (secretChar == guessChar){
                    countA ++;
                }else {
                    if(secretChars.contains(guessChar)){
                        guessBChars.add(guessChar);
                    }
                }
            }
            return countA + "A" + guessBChars.size() + "B";
        }
    }
}