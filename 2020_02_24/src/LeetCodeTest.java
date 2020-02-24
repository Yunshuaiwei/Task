import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/2/24 19:34
 **/
public class LeetCodeTest {
    public static void main(String[] args) {
//        String str="al&phaBET";
        Solution s = new Solution();
//        String s1 = s.toLowerCase(str);
//        System.out.println(s1);
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        s.rotate(arr, 3);
    }

}

class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
            result.append(chars[i]);
        }
        return result.toString();
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int j = i + k;
            if (j < arr.length) {
                nums[j] = arr[i];
            } else {
                if (k > 0) {
                    nums[k - 1] = arr[--length];
                } else {
                    nums[k] = arr[--length];
                }
                k--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}