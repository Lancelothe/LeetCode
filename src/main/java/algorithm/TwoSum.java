package algorithm;

import java.util.Arrays;

/**
 * @author hebohao
 * @date 2019/2/18
 */
public class TwoSum {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            int[] numbers = Arrays.copyOf(nums, nums.length);
            if (numbers.length == 0) {
                return null;
            }

            int[] result = new int[2];
            Arrays.sort(numbers);
            int min = 0;
            int max = numbers.length - 1;
            while (min < max) {
                if (numbers[min] + numbers[max] > target) {
                    max--;
                } else if (numbers[min] + numbers[max] < target) {
                    min++;
                } else {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[min] == numbers[max]) {
                            if (numbers[min] == nums[i] && result[0] == result[1]) {
                                result[0] = i;
                                continue;
                            }
                            if (numbers[max] == nums[i]) {
                                result[1] = i;
                            }
                        } else {
                            if (numbers[min] == nums[i]) {
                                result[0] = i;
                            }
                            if (numbers[max] == nums[i]) {
                                result[1] = i;
                            }
                        }
                    }
                    break;
                }

            }

            Arrays.sort(result);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,3};
        Solution solution = new Solution();
        int[] result = solution.twoSum(a, 6);
        System.out.println(Arrays.toString(result));

    }
}
